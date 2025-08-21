
package com.mycompany.lab_task_13;



public class Circle extends Shape implements  Resizable{
    
    private double radius;
    
    public Circle(String color,int x ,int y,double radius)
    {
        super(color,x,y);
        this.radius=radius;
    }
    
    public double calculateArea()
    {
        return Math.PI*radius*radius;
    }
    
    public void resize(int percentage)
    {
        radius *= (1.0 +(percentage / 100.0));
        
    }
    
}
