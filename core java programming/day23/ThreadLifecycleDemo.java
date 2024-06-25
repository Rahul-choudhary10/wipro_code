package day23;

public class ThreadLifecycleDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		final Object lock=new Object();
		Thread thread=new Thread(()->{
			try {
				System.out.println("State: "+ Thread.currentThread().getState());
				Thread.sleep(1000);
				System.out.println("After sleep, State: "+ Thread.currentThread().getState());
				synchronized (lock) {
					lock.wait();
				}
				System.out.println("After wait, State: "+ Thread.currentThread().getState());
			}catch (InterruptedException e){
				Thread.currentThread().interrupt();
			}
		});
		System.out.println("State after creation: "+ thread.getState());
		thread.start();
		System.out.println("State after start: "+ thread.getState());
		thread.join(500);
		System.out.println("State after join with timeout: "+ thread.getState());
		synchronized (lock) {
			lock.notify();
		}
		thread.join();
		System.out.println("State after join: "+thread.getState());
		
	}

}
