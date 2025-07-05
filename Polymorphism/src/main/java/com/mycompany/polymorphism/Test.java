
package com.mycompany.polymorphism;


public class Test {
    
    public static void main(String[] args) {
        
        Person p = new Person();
        p.Display();
        
        p = new Teacher();
        p.Display();
        
        p = new Student();
        p.Display();
    }
    
}
