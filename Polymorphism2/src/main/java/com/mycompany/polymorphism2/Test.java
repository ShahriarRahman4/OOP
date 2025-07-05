
package com.mycompany.polymorphism2;


public class Test {
    public static void main(String[] args) {
         Shape s1 = new Shape();
         Shape s2 = new Rectangle(5, 20);
         Shape s3 = new triangle(5,20);
         
         
         System.out.println(s1.area());
         System.out.println(s2.area());
         System.out.println(s3.area());
         
         
    }
    
}
