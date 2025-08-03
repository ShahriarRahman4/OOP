
package com.mycompany.lab_task_2;


public class Circle extends Shape {
     double radius;
     double result;
     
     
     
     public Circle(String name,String color,double radius)
    {
       super(name,color);
       this.radius=radius;
       this.result=Math.PI*radius*radius;
    }
     void Display()
     {
         super.Display();
         System.out.println("Area of the Circle : "+result);
     }
    
}
