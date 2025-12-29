package thread_creation;

//thread creation by extending the thread class
public class ThreadCreation1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread creation via extending class");
        //just to check random order
        /*
        for(;;){
            System.out.println("thread1");
        }
         */
    }
}
