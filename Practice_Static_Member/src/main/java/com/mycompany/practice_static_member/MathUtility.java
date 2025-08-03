
package com.mycompany.practice_static_member;



public class MathUtility {
    static int add(int a ,int b)
    {
        return a+b;
        
    }
    
    public static void main(String[] args)
    {
        int sum = MathUtility.add(10,2);
        
        System.out.println("Sum : "+sum);
    }
    
}
