package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCommunication {

    Object lock = new Object();
    
    public void test() {
        ThreadCommunication solution = new ThreadCommunication();
        AtomicInteger integer = new AtomicInteger(0);
        Runnable r = ()-> {
            try {
                solution.printNumber(integer);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);


        t1.start();
        t2.start();
    }

    public void printNumber(AtomicInteger integer) throws InterruptedException{
        synchronized(lock) {
            for(int i=0;i<5;i++) {
                lock.notify();
                System.out.println(Thread.currentThread().getName()+":"+integer.incrementAndGet());
                lock.wait();
            }
            
        }
    }
}
