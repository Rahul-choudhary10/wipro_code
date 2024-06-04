package Day_23;

class NumberPrinter extends Thread {
    private int start;
    private int end;

    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        NumberPrinter thread1 = new NumberPrinter(1, 10);
        NumberPrinter thread2 = new NumberPrinter(1, 10);

        thread1.start();
        thread2.start();
    }
}