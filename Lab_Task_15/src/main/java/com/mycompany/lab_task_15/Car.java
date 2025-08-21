
package com.mycompany.lab_task_15;


public class Car extends Venhicle implements Start, Drive {
    
    private int doors;
    
    public Car(String model, int year, int doors) {
        super(model, year);
        this.doors = doors;
    }
    
    public void startEngine() {
        System.out.println("Car engine started with key");
    }
    
    public void drive() {
        System.out.println("Driving car on road");
    }
    
    public void showInfo() {
        System.out.println("Car: " + model);
        System.out.println("Year: " + year);
        System.out.println("Doors: " + doors);
    }

    
    
}
