
package com.mycompany.lab_task_13;


public class Rectangle extends Shape implements Resizable {
    
    private double width;
    private double height;
    
    public Rectangle(String color,int x,int y,double width,double height)
    {
        super(color,x,y);
        this.width=width;
        this.height=height;
        
    }
    
    public double calculateArea()
    {
        return width*height;
    }
    
    public void resize(int percentage)
    {
        width *=(1.0+(percentage/100.0));
        height *=(1.0+(percentage/100.0));
        
    }
    
}
