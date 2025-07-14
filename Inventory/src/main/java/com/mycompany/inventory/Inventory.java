

package com.mycompany.inventory;


//Suppose you are developing a simple inventory system for an electronics store. The store sells various devices, and you need to keep track of basic information for each device, such as its name, price, and manufacturer.
//Every time a new device is added, this information should be stored, and the system should also keep count of how many devices have been added in total. You want to be able to retrieve this total number through a method whenever needed.
//Your task is to write a Java class named Device that includes:
//•	Fields to store name, price, and manufacturer.
//•	A constructor to initialize these values.
//•	A method to display the device's information.
//•	A method that returns the total number of devices added so far.



public class Inventory {

    String name;
    double price;
    String manufacturer;
    
    static int totalDevice=0;
    
    Inventory(String name,double price,String manufacturer)
    {
        this.name = name;
        this.price=price;
        this.manufacturer=manufacturer;
        totalDevice++;
    }
    
    void Display()
    {
        System.out.println("Device name : "+name);
        System.out.println("Price       : "+price);
        System.out.println("Manufracturer : "+manufacturer);
    }
    
   
}
