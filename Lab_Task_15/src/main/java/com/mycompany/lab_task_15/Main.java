
package com.mycompany.lab_task_15;


public class Main {
     public static void main(String[] args) {
        Car car = new Car("BMW", 2024, 5);
        Motorcycle bike = new Motorcycle("KTM", 2023, "Sports");
        Truck truck = new Truck("Toyota", 2020, 2.5);
        
        car.showInfo();
        car.startEngine();
        car.drive();
        System.out.println();
        
        bike.showInfo();
        bike.startEngine();
        bike.drive();
        System.out.println();
        
        truck.showInfo();
        truck.startEngine();
        truck.drive();
        System.out.println();
        
       
        Venhicle[] venhicles = {car, bike, truck};
        for (Venhicle venhicle : venhicles) {
            venhicle.showInfo();
            
            if (venhicle instanceof Start) {
                Start start = (Start) venhicle;
                start.startEngine();
            }
            
            if (venhicle instanceof Drive) {
                Drive drive = (Drive) venhicle;
                drive.drive();
            }
        }
     }     

    
}
