
package com.mycompany.lab_task_13;


public class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(String color,int x,int y,double base,double height )
    {
        super(color,x,y);
        this.base=base;
        this.height=height;
    }
    
    public double calculateArea()
    {
        return (base*height)/2;
    }
    
    
    
}
