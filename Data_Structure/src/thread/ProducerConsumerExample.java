package  thread;
import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
    private final Queue<Integer> queue = new LinkedList<Integer>();
    private final int MAX_SIZE = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        queue.add(value);
        System.out.println(Thread.currentThread().getName() + " produced: " + value);
        notifyAll(); // Waking up all threads
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                resource.produce(i);
                Thread.sleep(100); // delay
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int value = resource.consume();
                Thread.sleep(150); // delay
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource), "Producer");
        Thread consumerThread = new Thread(new Consumer(resource), "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
