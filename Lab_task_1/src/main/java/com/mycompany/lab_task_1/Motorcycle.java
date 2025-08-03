
package com.mycompany.lab_task_1;


public class Motorcycle extends Vehicle{
    String number_plate;
    String tank_cap;
    
    
    
      public Motorcycle(String brand,String model,String color,double price,String number_plate,String tank_cap)
      {
        super(brand,model,color,price);
        this.number_plate=number_plate;
        this.tank_cap=tank_cap;
      }
      
      void Display()
    {
        super.Display();
        System.out.println("Number Plate : "+number_plate);
        System.out.println("Tank Capacity :"+tank_cap);
        
    }
    
}
