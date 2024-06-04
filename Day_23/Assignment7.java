package Day_23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Thread-safe Counter class
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

// Immutable class for sharing data between threads
final class ImmutableData {
    private final String data;

    public ImmutableData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        // Creating a thread-safe counter
        Counter counter = new Counter();

        // Creating an immutable data object
        ImmutableData immutableData = new ImmutableData("Hello, Immutable!");

        // Creating an executor with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable to increment counter
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        // Runnable to decrement counter
        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        };

        // Runnable to access immutable data
        Runnable immutableDataTask = () -> {
            System.out.println(Thread.currentThread().getName() + " accessing immutable data: " + immutableData.getData());
        };

        // Submit tasks to the executor
        executor.submit(incrementTask);
        executor.submit(decrementTask);
        executor.submit(immutableDataTask);

        // Shutdown the executor
        executor.shutdown();

        // Wait until all tasks are completed
        while (!executor.isTerminated()) {
            // Waiting...
        }

        // Display the final count
        System.out.println("Final count: " + counter.getCount());
    }
}

