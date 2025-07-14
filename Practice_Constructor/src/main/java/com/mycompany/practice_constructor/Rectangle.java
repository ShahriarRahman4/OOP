
package com.mycompany.practice_constructor;
//Write a Java program to create a class called Rectangle with instance variables length and width.
//Implement a parameterized constructor and a copy constructor that initializes a new object using the values of an existing object. 
//        Print the values of the variables.
public class Rectangle {
    
    double length;
    double width;
    
    Rectangle(double length,double width)
    {
        this.length=length;
        this.width=width;
    }
    
    Rectangle(Rectangle rectangle)
    {
        this.length=rectangle.length;
        this.width=rectangle.width;
    }
    
    
    void Display()
    {
        System.out.println("Length : "+length);
        System.out.println("Width : "+width);
    }
    
}
