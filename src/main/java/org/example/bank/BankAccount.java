package org.example.bank;

/**
 * Created by santoshsharma on 25 Sep, 2022
 */

public class BankAccount {
    private double balance;
    private double minimumBalance;
    private String holderName;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double withdraw(double amount) {
        if(balance - amount >= minimumBalance) {
            balance -= amount;
            return amount;
        }

        throw new RuntimeException();
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
