import java.util.SortedSet;
 import java.util.TreeSet;
 
 class Lift {
     private int noOfFloor=7;
     public State state;
     public int currentFloor;
     public Direction direction;
     
     public SortedSet<Integer> upRequests = new TreeSet();
     public SortedSet<Integer> downRequests = new TreeSet();
 
     public void addRequest(Request externalRequest) {
         if(externalRequest.getDirectionToGo()==Direction.UP) {
             upRequests.add(externalRequest.getSourceFloor());
             upRequests.add(externalRequest.getDestination());
         } 
         if(externalRequest.getDirectionToGo()==Direction.DOWN) {
             downRequests.add(externalRequest.getSourceFloor());
             downRequests.add(externalRequest.getDestination());
         }
     }
 
 
     public void startLift() {
         while(true) {
             if(currentFloor == noOfFloor) {
                 this.direction= Direction.DOWN;
             }else if(currentFloor == 0) {
                 this.direction = Direction.UP;
             }
             if(this.state == State.IDLE && !upRequests.isEmpty()) {
                 this.direction = Direction.UP;
             }
             else if(this.state == State.IDLE && !downRequests.isEmpty()) {
                 this.direction = Direction.DOWN;
             }
 
             if(this.direction== Direction.UP){
                 if(!upRequests.isEmpty()) {
                     Integer up = upRequests.first();
                     while(up > currentFloor) {
                         moveUp();
                     }
                     while(up < currentFloor) {
                         moveDown();
                     }
                     upRequests.remove(up);
                 }else {
                     this.state=State.IDLE;
                 }
             }
             else {
                 if(!downRequests.isEmpty()) {
                     Integer down = downRequests.first();
                     while(down < currentFloor) {
                         moveDown();
                     }
                     while(down > currentFloor) {
                         moveUp();
                     }
                     downRequests.remove(down);
                 }else {
                     this.state=State.IDLE;
                 }
             }
         }
     }
 
     public void moveUp() {
         System.out.println("Going up");
         currentFloor++;
         try {
             Thread.sleep(2000);
             System.out.println("Reached at floor: "+currentFloor);
             if(upRequests.contains(currentFloor)) {
                 upRequests.remove(currentFloor);
                 System.out.println("Opening door");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     public void moveDown() {
         System.out.println("Going down");
         currentFloor--;
         try {
             Thread.sleep(2000);
             System.out.println("Reached at floor: "+currentFloor);
             if(downRequests.contains(currentFloor)) {
                 downRequests.remove(currentFloor);
                 System.out.println("Opening door");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     
 }
 enum Direction {
     UP,
     DOWN,
     IDLE
 }
 
 enum State {
     MOVING,
     IDLE;
 } 
 public class Elevator {
     
     
     public static void main(String[] args) {
         Lift lift = new Lift();
         lift.currentFloor=0;
         lift.state=State.IDLE;
         lift.direction=Direction.IDLE;
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 lift.startLift();
             }
         });  
         t1.start();
         Request upReq = new Request(Direction.UP,3,5);
         lift.addRequest(upReq);
         Request third = new Request(Direction.DOWN,1,0);
         lift.addRequest(third);
         Request fourth = new Request(Direction.DOWN,4,2);
         lift.addRequest(fourth);
 //        Request second = new Request(Direction.UP,2,4);
 //        lift.addRequest(second);
         
     }
 }
 
 class Request implements Comparable<Request> {    
     private Direction directionToGo;
     private Integer sourceFloor;
     private Integer destination;
 
     public Request(Direction directionToGo, int sourceFloor, int destination) {
         this.directionToGo = directionToGo;
         this.sourceFloor = sourceFloor;
         this.destination = destination;
     }
 
     public Direction getDirectionToGo() {
         return directionToGo;
     }    
     public void setDirectionToGo(Direction directionToGo) {
         this.directionToGo = directionToGo;
     }    
     public Integer getSourceFloor() {
         return sourceFloor;
     }    
     public void setSourceFloor(Integer sourceFloor) {
         this.sourceFloor = sourceFloor;
     }
     public Integer getDestination() {
         return destination;
     }    
     public void setDestination(Integer destination) {
         this.sourceFloor = destination;
     }
     @Override
     public int compareTo(Request obj) {
         return this.sourceFloor.compareTo(obj.getSourceFloor());
     }
 
     @Override
     public int hashCode() {
         return this.sourceFloor;
     }
 }