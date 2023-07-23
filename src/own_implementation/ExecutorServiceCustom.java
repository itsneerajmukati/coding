package own_implementation;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorServiceCustom {
    public static void main(String[] args) {
        MyExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<5;i++) {
            executorService.execute(new MyTask());
        }
    }

}

interface MyExecutorService {
    
    public void execute(Runnable r);
}

class Executors {
    public static MyExecutorService newFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }
}
class MyThreadPool implements MyExecutorService {
   
    static int capacity;
    static int currentCapacity;
 
    static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue;

    Execution e;

    public MyThreadPool(int cap) {
        capacity = cap;
        currentCapacity = 0;
        linkedTaskBlockingQueue = new LinkedBlockingQueue<>();
        e = new Execution();
    }

    // @Override
    public void execute(Runnable r)
    {
        // Declaring and adding tasks to
        // blocking queue using add() method
        linkedTaskBlockingQueue.add(r);
 
        // executeMyMethod() method of Execution class
        // which will execute the tasks
        e.executeMyMethod();
    }
}
class MyTask implements Runnable {
    public void run() {
        // Try block to check for exceptions
        try {
 
            // Making thread to pause fo a second
            // using sleep() method
            Thread.sleep(1000);
        }
 
        // Catch block to check for exceptions
        catch (InterruptedException e) {
 
            // Print the exception scaling ith line number
            // using printStackrace() method
            e.printStackTrace();
        }
        System.out.println("Current Thread :-> "
            + Thread.currentThread().getName());
    }

}
class Execution implements Runnable {
    public void executeMyMethod() {
        if(MyThreadPool.currentCapacity < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;
            Thread t = new Thread(new Execution());
            t.start();
        }
    }
    public void run() {
        while(true) {
            if (MyThreadPool.linkedTaskBlockingQueue.size()!= 0) {
                MyThreadPool.linkedTaskBlockingQueue.poll().run();
            }
        }
    }
}