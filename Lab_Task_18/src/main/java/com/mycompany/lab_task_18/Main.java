
package com.mycompany.lab_task_18;


public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTime = new FullTimeEmployee("A", "FT01", 5000, 20);
        PartTimeEmployee partTime = new PartTimeEmployee("B", "PT01", 25, 80);
        Contractor contractor = new Contractor("C", "CT01", 2000, 3);
        
       
        fullTime.showDetails();
        System.out.println("Fulltime Salary: " + fullTime.calculateSalary());
        fullTime.generateReport();
        System.out.println();
        
        partTime.showDetails();
        System.out.println("Partime Salary: " + partTime.calculateSalary());
        partTime.generateReport();
        System.out.println();
        
        contractor.showDetails();
        System.out.println("Project Earnings: " + contractor.calculateSalary());
        System.out.println();
        
        
        
        
    } 
    
}
