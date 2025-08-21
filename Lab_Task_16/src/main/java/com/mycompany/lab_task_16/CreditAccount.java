
package com.mycompany.lab_task_16;


public class CreditAccount extends Account implements Deposit, Withdraw{
    
  private double creditLimit;
    
    public CreditAccount(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }
    
    public void deposit(double amount) {
        balance = balance+amount;
        System.out.println("Payment made: " + amount);
    }
    
    public void withdraw(double amount) {
        if (amount <= creditLimit + balance) {
            balance =balance- amount;
            System.out.println("Credit used: " + amount);
        } else {
            System.out.println("Credit limit exceeded!");
        }
    }
    
    public void showInfo() {
        System.out.println("Credit Account: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Credit Limit: " + creditLimit);
    }  
}
