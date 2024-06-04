package Day_23;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance to withdraw: " + amount);
        }
    }
}

class TransactionThread extends Thread {
    private final BankAccount account;
    private final boolean isDeposit;
    private final double amount;

    public TransactionThread(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        TransactionThread[] threads = new TransactionThread[5];

        for (int i = 0; i < threads.length; i++) {
            if (i % 2 == 0) {
                threads[i] = new TransactionThread(account, true, 100); // Deposit
            } else {
                threads[i] = new TransactionThread(account, false, 200); // Withdraw
            }
        }

        for (TransactionThread thread : threads) {
            thread.start();
        }
    }
}

