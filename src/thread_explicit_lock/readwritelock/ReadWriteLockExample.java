package thread_explicit_lock.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    private static final Lock readLock = rwLock.readLock();
    private static final Lock writeLock = rwLock.writeLock();

    private static int sharedData = 0;

    public  int readData() {
        readLock.lock();
        try {
            return sharedData;
        } finally {
            readLock.unlock();
        }
    }

    public  void writeData() {
        writeLock.lock();
        try {

            sharedData++;
            Thread.sleep(50);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable readTask = new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){

                System.out.println(Thread.currentThread().getName()
                        + " read" + example.readData());
                }
            }
        };

        Runnable writeTask = new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    example.writeData();
                    System.out.println(Thread.currentThread().getName()
                            + " incremented");
                }
            }
        };
        // Multiple readers
        Thread reader1 = new Thread(readTask, "Reader-1");
        Thread reader2 = new Thread(readTask, "Reader-2");
        Thread reader3 = new Thread(readTask, "Reader-3");

        // One writer
        Thread writer = new Thread(writeTask, "Writer-1");

        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();

        writer.join();
        reader1.join();
        reader2.join();
        reader3.join();




    }
}
