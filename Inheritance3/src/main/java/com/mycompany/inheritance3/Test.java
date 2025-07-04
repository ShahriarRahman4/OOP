
package com.mycompany.inheritance3;


public class Test {
    public static void main(String[] args) {
        
        Animal A1 = new Animal();
        Person P1 = new Person();
        Teacher T1 = new Teacher();
        
        System.out.println(T1 instanceof Person);
        System.out.println(P1 instanceof Animal);
        System.out.println(T1 instanceof Animal);
        System.out.println(A1 instanceof Teacher);
    }
    
}
