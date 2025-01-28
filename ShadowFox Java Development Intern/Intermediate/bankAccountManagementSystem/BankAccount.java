package bankAccountManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accHoldName;
    private double balance;
    private List<String> tranHis;


    public BankAccount(String accountHolderName, double initialBalance) {
        this.accHoldName = accountHolderName;
        this.balance = initialBalance;
        this.tranHis = new ArrayList<>();
        tranHis.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        balance += amount;
        tranHis.add("Deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        tranHis.add("Withdrew: " + amount + " | Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return tranHis;
    }
}
