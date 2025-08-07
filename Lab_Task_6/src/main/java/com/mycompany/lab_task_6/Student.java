package com.mycompany.lab_task_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private int id;
    private String name;
    private String department;
    private double cgpa;

    static String university = "University of Liberal Arts Bangladesh";
    static ArrayList<Student> students = new ArrayList<>();

    public Student(int id, String name, String department, double cgpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
        students.add(this);
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("University: " + university);
    }

    public static void displayTotalStudents() {
        System.out.println("Total students: " + students.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students to register: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine();
            // Create Student Object
            new Student(id, name, department, cgpa);
        }

        System.out.println("Students :");
        for (Student student : students) {
            student.displayDetails();

        }

        displayTotalStudents();
        scanner.close();
    }
}
