
package com.mycompany.practice_static_member;


public class Initializer {
    static int initialValue;
    
    static{
        initialValue=1000;
        System.out.println("Static block initial value initialized to "+initialValue);
        
        
    }
    
    public static void main(String[] args) {
        System.out.println("Before creating an instance : "+Initializer.initialValue);
        
        Initializer ob1 =new  Initializer();
        
        System.out.println("After creating instance : "+ob1. initialValue);
    }
    
}
