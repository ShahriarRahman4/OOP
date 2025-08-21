
package com.mycompany.lab_task_13;


public abstract class Shape {
    protected String color;
    protected int x;
    protected int y;
    
    public Shape(String color,int x,int y)
    {
        this.color=color;
        this.x=x;
        this.y=y;
    }
    public abstract double calculateArea();
    
    
    
}
