package thread_creation;

public class ThreadCreationDemo {

    public static void main(String []args){
        ThreadCreation1 thread1 = new ThreadCreation1();
        thread1.start();

        Thread thread2 = new Thread(new ThreadCreation2());
        thread2.start();
    }
}
