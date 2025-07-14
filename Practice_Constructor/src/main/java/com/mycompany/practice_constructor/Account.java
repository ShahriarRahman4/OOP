
package com.mycompany.practice_constructor;


public class Account {
    
    String accountNumber;
    double balance;
    
    
    Account(String accountNumber ,double balance)
    {
        if(accountNumber == null || accountNumber.isEmpty())
        {
            System.out.println("Account number can not be null or empty");
            return;
        }
        if(balance<0)
        {
            System.out.println("Balance can not be negative");
        }
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    
    
    void Display()
    {
        System.out.println("Account Number :"+accountNumber);
        System.out.println("Balance : "+balance);
    }
    
}
