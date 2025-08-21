
package com.mycompany.lab_task_15;

public abstract class Venhicle {
    protected String model;
    protected int year;
    
    public Venhicle(String model, int year) {
        this.model = model;
        this.year = year;
    }
    
    public abstract void showInfo();
    
}
