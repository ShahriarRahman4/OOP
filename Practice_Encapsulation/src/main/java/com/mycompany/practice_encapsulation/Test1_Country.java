
package com.mycompany.practice_encapsulation;

import java.util.Scanner;

public class Test1_Country {
    
    public static void main(String[] args)
            
    {
        Scanner input  = new Scanner(System.in);
        Person ob1 = new Person();
        
        System.out.println("Enter Name : ");
        ob1.setName(input.nextLine());
        
        System.out.println("Enter age : ");
        ob1.setAge(input.nextInt());
        
        input.nextLine();
       
        
        System.out.println("Enter Country Name :");
        ob1.setCountry(input.nextLine());
        
        
//        ob1.setName("Rifat");
//        ob1.setAge(22);
//        ob1.setCountry("Bangladesh");
//        
        System.out.println("Name : "+ob1.getName());
        System.out.println("Age  : "+ob1.getAge());
        System.out.println("Country Name : "+ob1.getCountry());
        
        
    }
    
}
