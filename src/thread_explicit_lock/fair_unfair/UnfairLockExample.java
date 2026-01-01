package thread_explicit_lock.fair_unfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {

    private static final Lock lock = new ReentrantLock(); // UNFAIR (default)

    public static void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable task = UnfairLockExample::accessResource;

        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
