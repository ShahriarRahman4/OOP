package com.mycompany.lab_task_18;

public abstract class Employee {

    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract void showDetails();
}
