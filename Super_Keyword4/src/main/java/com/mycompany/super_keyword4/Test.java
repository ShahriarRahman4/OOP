
package com.mycompany.super_keyword4;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
       // Car ob1 = new Car("BMW",111,4);
       
        System.out.println("Enter Car name :");
        String name =input.nextLine();
        
        System.out.println("Enter Car weight :");
        Double weight = input.nextDouble();
        
        System.out.println("Enter numbers of gear :");
        int gear = input.nextInt();
        
        
        Car ob1 = new Car(name,weight,gear);
        
        ob1.Display();
        
    }
    
}
