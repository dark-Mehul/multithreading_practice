package thread_methods;

public class ThreadDaemon extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("Hello world!");
        }
    }

    public static void main(String []args){
        ThreadDaemon t1 = new ThreadDaemon();
        // from the below code we can see that ur loop is infinite ,but it finishes when we create our thread as daemon that is the catch
        //our main thread will only wait for user thread not for daemon thread.
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main is done");


    }
}
