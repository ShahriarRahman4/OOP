
package com.mycompany.lab_task_16;


public class SavingsAccount extends Account implements Deposit, Withdraw{
     private double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    public void deposit(double amount) {
        balance =balance+ amount;
        System.out.println("Deposited: " + amount);
    }
    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance- amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    public void showInfo() {
        System.out.println("Savings Account: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    
    
}
