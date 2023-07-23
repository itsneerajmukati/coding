package own_implementation;

public class MyStackUsingArray {

    int top;
    int[] stack =  new int[100];
    public MyStackUsingArray() {
        top = -1;
    }
    
    public boolean push(int data) {
        if(top > stack.length-1) {
            System.out.println("Overflow");
            return false;
        }
        stack[++top]=data;
        return true;
    }
    public int pop() {
        if(top < 0) {
            System.out.println("Underflow");
            return 0;
        }
        return stack[top--];
    }
    public int peek() {
        if(top < 0) {
            System.out.println("Underflow");
            return 0;
        }
        return stack[top];
    }

    void print(){
        for(int i = top;i>-1;i--){
          System.out.print(" "+ stack[i]);
        }
    }

}
