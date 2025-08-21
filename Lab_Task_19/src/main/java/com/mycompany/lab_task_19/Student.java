
package com.mycompany.lab_task_19;


public  abstract class Student {
    protected String name;
    protected String studentId;
    
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }
    
    public abstract void showDetails();
    
    
}
