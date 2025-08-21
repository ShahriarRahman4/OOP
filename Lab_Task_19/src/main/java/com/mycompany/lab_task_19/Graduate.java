
package com.mycompany.lab_task_19;


public class Graduate extends Student implements Enrollable, Researchable {
    private String program;
    private String thesisTopic;
    
    public Graduate(String name, String studentId, String program, String thesisTopic) {
        super(name, studentId);
        this.program = program;
        this.thesisTopic = thesisTopic;
    }
    
    public void enrollCourse(String course) {
        System.out.println(name + " enrolled in graduate course: " + course);
    }
    
    public void conductResearch() {
        System.out.println(name + " is conducting research on: " + thesisTopic);
    }
    
    public void showDetails() {
        System.out.println("Graduate Student: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Program: " + program);
        System.out.println("Thesis Topic: " + thesisTopic);
    }
    
}
