package thread_explicit_lock;

public class Demo {
    public static void main(String []args){
//        BankAccountWithSynchronized sbi =  new BankAccountWithSynchronized();
//        Runnable task = new Runnable(){
//            @Override
//            public void run(){
//                sbi.withdraw(50);
//            }
//        };
//
//        Thread t1 = new Thread(task,"Thread 1");
//        Thread t2 = new Thread(task,"Thread 2");
//        t1.start();
//        t2.start();

        BankAccountWithLock kotak =  new BankAccountWithLock();
        Runnable task1 = new Runnable(){
            @Override
            public void run(){
                kotak.withdraw(50);
            }
        };

        Thread t3 = new Thread(task1,"Thread 3");
        Thread t4 = new Thread(task1,"Thread 4");
        t3.start();
        t4.start();


    }
}
