package Day_23;

public class Assignment2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is in NEW state");

                Thread.sleep(1000);
                System.out.println("Thread is now in RUNNABLE state");
                synchronized (Assignment2.class) {
                    System.out.println("Thread is in BLOCKED state");
                    Thread.sleep(2000); 
                }
                synchronized (Assignment2.class) {
                    System.out.println("Thread is in WAITING state");
                    Assignment2.class.wait();
                }
                synchronized (Assignment2.class) {
                    System.out.println("Thread is in TIMED_WAITING state");
                    Thread.sleep(3000); 
                }
                System.out.println("Thread is in TERMINATED state");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

