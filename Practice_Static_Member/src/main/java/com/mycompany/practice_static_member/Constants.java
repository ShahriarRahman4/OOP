
package com.mycompany.practice_static_member;


public class Constants {
    static final double PI=3.1416;
    
    static double CalculateArea(double radius)
    {
        return PI*radius*radius;
    }
    
    public static void main(String[] args) {
        
        double radius =5;
        double area = CalculateArea(5);
        
        System.out.println("Radius : "+radius);
        System.out.println("Area : "+area);
       
    }
    
}
