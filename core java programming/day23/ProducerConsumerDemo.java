package day23;
import java.util.LinkedList;
import java.util.Queue;

class Buffer{
	private final Queue<Integer> queue=new LinkedList<>();
	private final int capacity;
	
	public Buffer(int capacity) {
		this.capacity=capacity;
	}
	public synchronized void produce(int value) throws InterruptedException{
		while(queue.size()==capacity) {
			wait();
		}
		queue.offer(value);
		System.out.println("Produced "+value);
		notifyAll();
	}
	public synchronized int consume() throws InterruptedException{
		while(queue.isEmpty()) {
			wait();
		}
		int value=queue.poll();
		System.out.println("Consumed "+value);
		notifyAll();
		return value;
	}
}
class Producer implements Runnable{
	private final Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer=buffer;
	}
	public void run() {
		int value=0;
		try {
			while(true) {
				buffer.produce(value++);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
class Consumer implements Runnable{
	private final Buffer buffer;
	public Consumer(Buffer buffer) {
		this.buffer=buffer;
		
				
	}
	public void run() {
		try {
			while(true) {
				buffer.consume();
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Buffer buffer=new Buffer(5);
		Thread producerThread=new Thread(new Producer(buffer));
		Thread consumerThread = new Thread(new Consumer(buffer));
		
		producerThread.start();
		consumerThread.start();
	}

}
