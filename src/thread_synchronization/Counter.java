package thread_synchronization;

public class Counter {

    private int count = 0;

    // just removed the synchronized and see  you will never reach 2000 because every time both of the thread will read the same value at many instances
    // and that results in race condition(where both thread are trying to access the same thing).
    // which result in inconsistent data

    // you can have the whole method as synchronized or
    // the block level synchronized (block level is good)

    //synchronized will add a lock and the code  will act as critical section
    // whole method synchronized
    public synchronized void methodLevelIncrement(){
        count++;
    }

    //block level synchronized
    public  void blockLevelIncrement(){
        synchronized(this){
            count++;
        }
    }

    public  void normalIncrement(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
