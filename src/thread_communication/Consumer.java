package thread_communication;

public class Consumer implements Runnable{

    private final SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            int val = resource.consume();

        }

    }
}
