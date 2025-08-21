
package com.mycompany.lab_task_16;


public class Main {
     public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("S1", 12000, 2.5);
        CheckingAccount checking = new CheckingAccount("C1", 1500, 700);
        CreditAccount credit = new CreditAccount("C1", 20000, 1000);
        
       
        savings.showInfo();
        savings.deposit(300);
        savings.withdraw(150);
        savings.showInfo();
        System.out.println();
        
        checking.showInfo();
        checking.deposit(100);
        checking.withdraw(650);
        checking.showInfo();
        System.out.println();
        
        credit.showInfo();
        credit.deposit(100);
        credit.withdraw(800);
        credit.showInfo();
        System.out.println();
        
      
    }
    
}
