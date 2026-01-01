package thread_methods;

public class ThreadMethod2 extends Thread{
    @Override
    public void run() {
        try {

            //Thread.sleep(5000);
            for(int i=0;i<6;i++){
                System.out.println(Thread.currentThread().getName() +" is Running");
                Thread.yield();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        ThreadMethod2 t1 = new ThreadMethod2();
        ThreadMethod2 t2 = new ThreadMethod2();
       t1.start();
       t2.start();
       //t1.interrupt();
    }
}
