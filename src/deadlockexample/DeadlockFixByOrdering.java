package deadlockexample;

public class DeadlockFixByOrdering {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread writer1 = new Thread(() -> {
            pen.writeWithPenAndPaper(paper);   // PEN → PAPER
        }, "Writer-1");

        Thread writer2 = new Thread(() -> {
            pen.writeWithPenAndPaper(paper);   // PEN → PAPER
        }, "Writer-2");

        writer1.start();
        writer2.start();
    }
}
