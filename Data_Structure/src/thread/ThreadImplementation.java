package thread;

class MyThread extends Thread{
	public void run() {
		for(int i=1;i<=3;i++)
		{
			System.out.println("child Thread "+ i);
		}
			}
	}
 
 
public class ThreadImplementation {
 
	public static void main(String[] args) {
		MyThread t=new MyThread();
		t.start();		
		
		for(int i=1;i<=3;i++)
		{
			System.out.println("Main Thread "+ i);
		}
	}
 
}
 
