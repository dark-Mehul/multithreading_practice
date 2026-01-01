package thread_explicit_lock.fair_unfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {

    private static final Lock lock = new ReentrantLock(true); // FAIR

    public static void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {


//        Runnable task1 = new Runnable(){
//            @Override
//            public void run() {
//                FairLockExample.accessResource();
//            }
//        };
        //above is normal declaration
        Runnable task = FairLockExample::accessResource;

        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
