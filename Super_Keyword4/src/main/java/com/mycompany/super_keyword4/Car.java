
package com.mycompany.super_keyword4;


public class Car extends Venhicle{
    
    int gear;
    
    Car(String name,double weight ,int gear)
    {   
        super(name,weight);
       this.gear=gear;
    }
    
    void Display()
    {
        super.Display();
        System.out.println("Gear :"+gear);
                
    }
    
}
