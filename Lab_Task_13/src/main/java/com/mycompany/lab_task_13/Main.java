
package com.mycompany.lab_task_13;


public class Main {
    public static void main(String[] args)
    {
        
        Circle circle=new Circle("Red",0,0,5.0);
        Rectangle rectangle=new Rectangle("Blue",0,0,4.0,6.0);
        Triangle triangle= new Triangle("Green",0,0,3.0,4.0);
        
        System.out.println("Circle Area :"+circle.calculateArea());
        System.out.println("Rectangle Area :"+rectangle.calculateArea());
        System.out.println("Triangle Area : "+triangle.calculateArea());
        
        if(circle instanceof Resizable)
        {
            Resizable resizableCircle=(Resizable) circle;
            resizableCircle.resize(50);
            System.out.println("Resized Circle Area : "+circle.calculateArea());
        }
        
         if(rectangle instanceof Resizable)
        {
            Resizable resizableRectangle=(Resizable) rectangle;
            resizableRectangle.resize(50);
            System.out.println("Resized Rectangle Area : "+rectangle.calculateArea());
        }
        
        
        
        
    }    
}
