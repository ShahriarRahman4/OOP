
package com.mycompany.lab_task_18;


public class PartTimeEmployee extends Employee implements Payable, Reportable {
    private double hourlyRate;
    private int hoursWorked;
    
    public PartTimeEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    public void generateReport() {
        System.out.println("Part-Time Employee Report: " + name);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: " + calculateSalary());
    }
    
    public void showDetails() {
        System.out.println("Part-Time Employee: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: " + calculateSalary());
    }
}
