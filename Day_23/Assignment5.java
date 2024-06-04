package Day_23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ComplexCalculationTask implements Runnable {
    private int taskId;

    public ComplexCalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started");
        // Simulate a complex calculation or I/O operation
        try {
            // Simulate a complex calculation
            long result = 0;
            for (int i = 0; i < 1000000; i++) {
                result += i;
            }
            System.out.println("Task " + taskId + " completed. Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit multiple tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new ComplexCalculationTask(i);
            executor.submit(task);
        }

        // Shutdown the executor after submitting all tasks
        executor.shutdown();
    }
}

