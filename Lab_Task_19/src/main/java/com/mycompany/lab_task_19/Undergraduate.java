
package com.mycompany.lab_task_19;


public class Undergraduate extends Student implements Enrollable {
    private String major;
    private int completedCredits;
    
    
    public Undergraduate(String name, String studentId, String major, int completedCredits) {
        super(name, studentId);
        this.major = major;
        this.completedCredits = completedCredits;
    }
    
    public void enrollCourse(String course) {
        System.out.println(name + " enrolled in undergraduate course: " + course);
        completedCredits =completedCredits+ 2; 
    }
    
    public void showDetails() {
        System.out.println("Undergraduate Student: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Major: " + major);
        System.out.println("Completed Credits: " + completedCredits);
    }
    
    
    
    
}
