
package com.mycompany.lab_task_1;


public class Vehicle {
    String brand;
    String model;
    String color;
    double price;
    
    public Vehicle(String brand,String model,String color,double price)
    {
        this.brand=brand;
        this.model=model;
        this.color=color;
        this.price=price; 
    }
    
    void Display()
    {
        System.out.println("Brand : "+brand);
        System.out.println("Model : "+model);
        System.out.println("Color : "+color);
        System.out.println("Price : "+price);
    }
    
    
}
