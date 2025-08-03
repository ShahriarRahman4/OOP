package com.mycompany.lab_task_3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Engineer Details:");
        System.out.print("Name: ");
        String engName = scanner.nextLine();
        System.out.print("ID: ");
        String engId = scanner.nextLine();
        System.out.print("Skills: ");
        String skills = scanner.nextLine();
        System.out.print("Base Salary: ");
        double engSalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double engBonus = scanner.nextDouble();
        scanner.nextLine();

        Engineer engineer = new Engineer(engName, engId, skills, engSalary, engBonus);
        System.out.println();

        System.out.println("Enter Manager Details:");
        System.out.print("Name: ");
        String mgrName = scanner.nextLine();
        System.out.print("ID: ");
        String mgrId = scanner.nextLine();
        System.out.print("Years of Experience: ");
        int experience = scanner.nextInt();
        System.out.print("Base Salary: ");
        double mgrSalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double mgrBonus = scanner.nextDouble();

        Manager manager = new Manager(mgrName, mgrId, experience, mgrSalary, mgrBonus);

        System.out.println("Engineer Information:");
        engineer.Display();

        System.out.println("Manager Information:");
        manager.Display();

        scanner.close();
    }
}