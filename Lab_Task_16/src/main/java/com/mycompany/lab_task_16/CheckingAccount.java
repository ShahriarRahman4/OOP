
package com.mycompany.lab_task_16;


public class CheckingAccount extends Account implements Deposit, Withdraw {
    private double overdraftLimit;
    
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    public void deposit(double amount) {
        balance =balance+amount;
        System.out.println("Deposited: " + amount);
    }
    
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance =balance- amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
    public void showInfo() {
        System.out.println("Checking Account: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
    
    
}
