
package com.mycompany.lab_task_18;


public class FullTimeEmployee extends Employee implements Payable, Reportable  {
     private double monthlySalary;
    private int vacationDays;
    
    public FullTimeEmployee(String name, String employeeId, double monthlySalary, int vacationDays) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
    }
    
    public double calculateSalary() {
        return monthlySalary;
    }
    
    public void generateReport() {
        System.out.println("Full-Time Employee Report: " + name);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Vacation Days: " + vacationDays);
    }
    
    public void showDetails() {
        System.out.println("Full-Time Employee: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Vacation Days: " + vacationDays);
    }
    
}
