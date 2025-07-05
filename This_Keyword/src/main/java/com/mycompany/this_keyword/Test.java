
package com.mycompany.this_keyword;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter name : ");
        String name = input.nextLine();
        
        System.out.println("Enter age : ");
        int age = input.nextInt();
        input.nextLine();
        
        Person ob1 = new Person(name,age);
        ob1.Display();
        
        System.out.println("Enter name2 : ");
        String name2 = input.nextLine();
        
        
        
        System.out.println("Enter age2 : ");
        int age2 = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter hair Color : ");
        String hairColor= input.nextLine();
        
        Person ob2 = new Person(name2,age2,hairColor);
        ob2.Display();
        
        
        input.close();
        
    }
    
}
