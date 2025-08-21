
package com.mycompany.lab_task_19;


public class Doctoral  extends Student implements Enrollable, Researchable {
    private String dissertationTitle;
    private int researchHours;
    
    public Doctoral(String name, String studentId, String dissertationTitle, int researchHours) {
        super(name, studentId);
        this.dissertationTitle = dissertationTitle;
        this.researchHours = researchHours;
    }
    
    public void enrollCourse(String course) {
        System.out.println(name + " enrolled in doctoral seminar: " + course);
    }
    
    public void conductResearch() {
        researchHours += 10;
        System.out.println(name + " conducted research on dissertation: " + dissertationTitle);
        System.out.println("Total research hours: " + researchHours);
    }
    
    public void showDetails() {
        System.out.println("Doctoral Student: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Dissertation: " + dissertationTitle);
        System.out.println("Research Hours: " + researchHours);
    }
    
    
}
