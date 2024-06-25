package day23;

public class Main {

	 public static class Counter {
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

	    public static final class ImmutableData {
	        private final int value;

	        public ImmutableData(int value) {
	            this.value = value;
	        }

	        public int getValue() {
	            return value;
	        }
	    }

	    public static void main(String[] args) {
	        Counter counter = new Counter();
	        ImmutableData immutableData = new ImmutableData(0);

	        Runnable incrementTask = () -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.increment();
	                System.out.println("Incremented: " + counter.getCount());
	            }
	        };

	        Runnable decrementTask = () -> {
	            for (int i = 0; i < 1000; i++) {
	                counter.decrement();
	                System.out.println("Decremented: " + counter.getCount());
	            }
	        };

	        Runnable readTask = () -> {
	            for (int i = 0; i < 10; i++) {
	                System.out.println("Immutable data value: " + immutableData.getValue());
	            }
	        };

	        Thread t1 = new Thread(incrementTask);
	        Thread t2 = new Thread(decrementTask);
	        Thread t3 = new Thread(readTask);

	        t1.start();
	        t2.start();
	        t3.start();
	    }
}
