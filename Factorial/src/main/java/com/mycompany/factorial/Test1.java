
package com.mycompany.factorial;

import java.util.Scanner;


public class Test1 {
    
    public static void main(String[] args)
            
    {
        Scanner input =new Scanner(System.in);
        int number;
        number=input.nextInt();
        
        FactorialDemo ob1 = new FactorialDemo();
        int result=ob1.fact(number);
        
        System.out.println("Factorial of "+number+":  "+result);
        
    }
    
}
