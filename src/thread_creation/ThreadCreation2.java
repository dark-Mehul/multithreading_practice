package thread_creation;

public class ThreadCreation2 implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread creation using runnable interface");
        //just to check random order
        /*
        for(;;){
            System.out.println("thread2");
        }
         */
    }
}
