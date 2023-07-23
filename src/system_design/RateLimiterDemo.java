package system_design;

import java.util.*;
import java.util.concurrent.*;

public class RateLimiterDemo {
    public static void main(String[] args) throws Exception{
        RequestRateLimiter requestRateLimiter = RequestRateLimiter.getInstance();
        ExecutorService executors = Executors.newFixedThreadPool(10);
        for(int i=1;i<10;i++) {
            executors.execute(()->requestRateLimiter.request(1));
        }
        Thread.sleep(2000);
        executors.shutdown();
        executors = Executors.newFixedThreadPool(10);
        for(int i=1;i<10;i++) {
            executors.execute(()->requestRateLimiter.request(1));
        }
        executors.shutdown();
    }
 }

interface RateLimiter {
    public boolean checkLimit();
}

class FixedWindowRateLimiter implements RateLimiter {
    private final int tps;
    private long lastExecutionTime;
    private long nextWindowTime;
    private long counter;

    private final Object lock = new Object();

    public FixedWindowRateLimiter(int rate) {
        this.tps = rate;
        this.counter = 0;
        this.lastExecutionTime = 0L;
        this.nextWindowTime = 0L;
    }

    @Override
    public boolean checkLimit() {
        //block every request
        if (tps == 0L) {
            return false;
        }
        synchronized(lock) {
            //first request
            long now = new Date().getTime();
            if(lastExecutionTime == 0L) {
                counter++;
                lastExecutionTime =  now;
                nextWindowTime = lastExecutionTime + 1000; // adding 1 sec because per second tps is given
                return true;
            } else { // second request onwards
                if(now < nextWindowTime) {
                    if(counter < tps) {
                        counter++;
                        lastExecutionTime =  now;
                        return true;
                    } else {
                        return false;
                    }
                }else {
                  // Reset the counter
                    counter = 0;
                    lastExecutionTime = 0L;
                    nextWindowTime = 0L;
                    return checkLimit();
                }
            }
        }
    }

}

class RequestRateLimiter {

    private static RequestRateLimiter instance;

    Map<Integer,RateLimiter> userMap = new ConcurrentHashMap<>();

    public synchronized void request(Integer userId) {
        //check the limit if user has previous request
        if(userMap.containsKey(userId)) {
            if(userMap.get(userId).checkLimit()) {
                System.out.println(Thread.currentThread().getName()+ "request served");
            }else {
                System.out.println(Thread.currentThread().getName()+ "to many request");
            }
        }else {
            // add user for request
            userMap.put(userId,new FixedWindowRateLimiter(2)); // here 2 is fixed but can be fetched from db or any config
            request(userId);
        }
    }

    public static RequestRateLimiter getInstance() {
        if(instance == null) {
            instance = new RequestRateLimiter();
        }
        return instance;
    }
    
    
}

