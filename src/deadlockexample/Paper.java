package deadlockexample;

public class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName()
                + " is using PAPER " + this
                + " and trying to acquire PEN");

        // tries to acquire Pen lock
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName()
                + " finished writing using PAPER " + this);
    }
}
