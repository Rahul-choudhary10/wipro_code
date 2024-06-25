package day23;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CalculationTask implements Runnable{
	private final int taskId;
	
	public CalculationTask(int taskId) {
		this.taskId=taskId;
	}
	public void run() {
		System.out.println("Task "+ taskId + " started.");
		performComplexCalculation();
		System.out.println("Task "+ taskId + " completed.");
	}
	private void performComplexCalculation() {
		long sum=0;
		for(long i=0;i<1000000000L;i++) {
			sum+=i;
		}
		System.out.println("Task "+ taskId + " calculation result: "+ sum);
	}
}
public class ThreadPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfThreads=4;
		ExecutorService executorService=Executors.newFixedThreadPool(numberOfThreads);
		for(int i=1;i<=10;i++) {
			executorService.submit(new CalculationTask(i));
		}
		executorService.shutdown();
		try {
			if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		}catch (InterruptedException e) {
			executorService.shutdownNow();
		}

	}

}
