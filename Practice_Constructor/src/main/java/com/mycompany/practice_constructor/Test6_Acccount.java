
package com.mycompany.practice_constructor;

import java.util.Scanner;

public class Test6_Acccount {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Account number : ");
        String accountNumber = input.nextLine();
        
        System.out.println("Enter Balance : ");
        double balance = input.nextDouble();
        
        Account ob1 = new Account(accountNumber ,balance);
        
        ob1.Display();
        
    }
    
    
}
