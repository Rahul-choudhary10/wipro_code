package day23;

class BankAccount {
	private int balance;
	public BankAccount(int initialBalance) {
		this.balance=initialBalance;
	}
	public synchronized void deposit(int amount) {
		balance +=amount;
		System.out.println(Thread.currentThread().getName()+ "deposited "+ amount+ ",current balance: "+ balance);
	}
	public synchronized void withdraw(int amount) {
		if(balance >=amount) {
			balance -=amount;
			System.out.println(Thread.currentThread().getName()+ " withdrew "+amount+" , current balance: "+balance);
		}else {
			System.out.println(Thread.currentThread().getName()+" tried to withdraw "+amount + " , but only "+balance+" is availabe. Withdrawal failed.");
			}
	}
	public int getBalance() {
		return balance;
		}
	}
class DepositTask implements Runnable{
	private BankAccount account;
	private int amount;
	
	public DepositTask(BankAccount account,int amount) {
		this.account=account;
		this.amount=amount;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			account.deposit(amount);
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
class WithdrawTask implements Runnable{
	private BankAccount account;
	private int amount;
	
	public WithdrawTask(BankAccount account,int amount) {
		this.account=account;
		this.amount=amount;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			account.withdraw(amount);
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
public class BankAccountDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount account=new BankAccount(1000);
		Thread depositThread1=new Thread(new DepositTask(account,100),"DepositThread1");
		Thread  depositThread2=new Thread(new DepositTask(account,150),"DepositThread2");
		Thread withdrawThread1=new Thread(new WithdrawTask(account,200),"WithdrawThread1");
		Thread withdrawThread2=new Thread(new WithdrawTask(account,50),"WithdrawThread2");
		
		depositThread1.start();
		depositThread2.start();
		withdrawThread1.start();
		withdrawThread2.start();
	}

}
