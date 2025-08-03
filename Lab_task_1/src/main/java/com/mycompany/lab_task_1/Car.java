
package com.mycompany.lab_task_1;


public class Car extends Vehicle {
    
    String regis_num;
    public Car(String brand,String model,String color,double price,String regis_num)
    {
        super(brand,model,color,price);
        this.regis_num=regis_num;
    }
    
    void Display()
    {
        super.Display();
        System.out.println("Registration Number : "+regis_num);
        
    }
        
 
}
