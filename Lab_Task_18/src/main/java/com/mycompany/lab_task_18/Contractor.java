
package com.mycompany.lab_task_18;

public class Contractor extends Employee implements Payable {
    private double projectRate;
    private int numberOfProjects;
    
    public Contractor(String name, String employeeId, double projectRate, int numberOfProjects) {
        super(name, employeeId);
        this.projectRate = projectRate;
        this.numberOfProjects = numberOfProjects;
    }
    
    public double calculateSalary() {
        return projectRate * numberOfProjects;
    }
    
    public void showDetails() {
        System.out.println("Contractor: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Project Rate: " + projectRate);
        System.out.println("Number of Projects: " + numberOfProjects);
        System.out.println("Total Earnings: " + calculateSalary());
    }
    
}
