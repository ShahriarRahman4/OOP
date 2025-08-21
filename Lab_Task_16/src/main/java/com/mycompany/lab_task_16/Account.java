
package com.mycompany.lab_task_16;


public abstract class Account {
    protected String accountNumber;
    protected double balance;
    
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public abstract void showInfo();
    
}
