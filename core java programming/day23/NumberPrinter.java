package day23;

public class NumberPrinter implements Runnable {
	private String threadName;
	
	public NumberPrinter(String threadName) {
		this.threadName=threadName;
	}
	public void run() {
		try {
			for(int i=1;i<=10;i++) {
				System.out.println(threadName + ": "+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.println(threadName + "interrupted.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable printer1=new NumberPrinter("Thread 1");
		Runnable printer2=new NumberPrinter("Thread 2");
		
		Thread thread1 = new Thread(printer1);
		Thread thread2=new Thread(printer2);
		
		thread1.start();
		thread2.start();
	}

}
