
package com.mycompany.lab_task_2;


public class Shape {
    
    String name;
    String color;
    
    public Shape(String name,String color)
    {
        this.name=name;
        this.color=color;
    }
    
    void Display()
    {
        System.out.println(name+":");
        System.out.println("Color :"+color);
    }
    
}
