package thread_explicit_lock.fair_unfair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairProveExample {

    private static final Lock lock = new ReentrantLock(); // UNFAIR

    public static void accessResource() {
        for (int i = 0; i < 3; i++) { // retry multiple times
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Runnable task = UnfairProveExample::accessResource;

        for (int i = 1; i <= 3; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
