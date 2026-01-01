package deadlockexample;

public class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName()
                + " is using PEN " + this
                + " and trying to acquire PAPER");

        // tries to acquire Paper lock
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName()
                + " finished writing using PEN " + this);
    }
}
