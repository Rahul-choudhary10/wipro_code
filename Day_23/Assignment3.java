package Day_23;

import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, producer is waiting...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing: " + i);
                queue.offer(i);
                queue.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, consumer is waiting...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = queue.poll();
                System.out.println("Consuming: " + item);
                queue.notifyAll();
            }
        }
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 3;
        Producer producer = new Producer(queue, maxSize);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
