package deadlockexample;

public class DeadLockExample {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread writer1 = new Thread(() -> {
            pen.writeWithPenAndPaper(paper);
        }, "Writer-1");

        Thread writer2 = new Thread(() -> {
            paper.writeWithPaperAndPen(pen);
        }, "Writer-2");

        writer1.start();
        writer2.start();
    }
}
