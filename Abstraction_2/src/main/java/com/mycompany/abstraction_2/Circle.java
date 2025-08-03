
package com.mycompany.abstraction_2;


public  class Circle extends Shape {
    
    Circle(double r)
    {
        super(r,r);
    }
    
    void area()
    {
        double result =Math.PI*d1*d2;
        System.out.println("Triangle area : "+result);
    }
    
    
    
}
