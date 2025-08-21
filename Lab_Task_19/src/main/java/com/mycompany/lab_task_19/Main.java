package com.mycompany.lab_task_19;

public class Main {

    public static void main(String[] args) {
        Undergraduate undergrad = new Undergraduate("A", "123", "CSE", 45);
        Graduate graduate = new Graduate("B", "321", "MBA", "BBA");
        Doctoral doctoral = new Doctoral("C", "456", "MSJ", 120);

        undergrad.showDetails();
        undergrad.enrollCourse("Data Structures");
        undergrad.showDetails();
        System.out.println();

        graduate.showDetails();
        graduate.enrollCourse("Advanced Statistics");
        graduate.conductResearch();
        System.out.println();

        doctoral.showDetails();
        doctoral.enrollCourse("Research Methodology");
        doctoral.conductResearch();
        doctoral.showDetails();
        System.out.println();

        Student[] students = {undergrad, graduate, doctoral};
        for (Student student : students) {
            student.showDetails();

            if (student instanceof Enrollable) {
                Enrollable enrollable = (Enrollable) student;
                enrollable.enrollCourse("Elective Course");
            }

            if (student instanceof Researchable) {
                Researchable researchable = (Researchable) student;
                researchable.conductResearch();
            }

            System.out.println(" ");
        }

        System.out.println("summary of a  student");
        for (Student student : students) {
            System.out.println(student.name + " (" + student.studentId + ")");

            if (student instanceof Enrollable) {
                System.out.println("  - Can enroll in courses");
            }

            if (student instanceof Researchable) {
                System.out.println("  - Can conduct research");
            }

            System.out.println();
        }
    }

}
