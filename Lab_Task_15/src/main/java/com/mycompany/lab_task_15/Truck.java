
package com.mycompany.lab_task_15;


public class Truck extends Venhicle implements Start, Drive{
    private double loadCapacity;
    
    public Truck(String model, int year, double loadCapacity) {
        super(model, year);
        this.loadCapacity = loadCapacity;
    }
    
    public void startEngine() {
        System.out.println("Truck engine started with button");
    }
    
    public void drive() {
        System.out.println("Driving truck with heavy load");
    }
    
    public void showInfo() {
        System.out.println("Truck: " + model);
        System.out.println("Year: " + year);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
    
}
