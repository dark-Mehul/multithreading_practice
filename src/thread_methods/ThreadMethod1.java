package thread_methods;

import thread_stages.ThreadStageDemo;

public class ThreadMethod1 extends Thread{


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +"---" + Thread.currentThread().getPriority());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        ThreadMethod1 t1 = new ThreadMethod1();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        Thread.sleep(100);
        t1.join();
    }
}
