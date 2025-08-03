
package com.mycompany.lab_task_2;


public class Rectangle extends Shape {
    double length;
    double width;
    double result;
    
    public Rectangle(String name,String color,double length,double width)
    {
        super(name,color);
        this.length=length;
        this.width=width;
        this.result=length*width;
    }
   
   void Display()
   {
       super.Display();
       System.out.println("Area of the Rectangle : "+result);
   }
    
        
    
}
