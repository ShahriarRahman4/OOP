package com.mycompany.returningvalue;

import java.util.Scanner;


public class Test
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter any number :");
        int num;
        num=input.nextInt();
        
        ReturingValue ob1 = new ReturingValue();
        int result = ob1.square(num);
        System.out.println("Square of "+num+" = "+result);
        
    }
}

