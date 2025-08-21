
package com.mycompany.lab_task_15;


public class Motorcycle extends Venhicle implements Start, Drive
{
    private String type;
    
    public Motorcycle(String model, int year, String type) {
        super(model, year);
        this.type = type;
    }
    
    public void startEngine() {
        System.out.println("Motorcycle engine started with kick");
    }
    
    public void drive() {
        System.out.println("Riding motorcycle");
    }
    
    public void showInfo() {
        System.out.println("Motorcycle: " + model);
        System.out.println("Year: " + year);
        System.out.println("Type: " + type);

    }
    
}
