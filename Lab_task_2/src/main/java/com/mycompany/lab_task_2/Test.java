package com.mycompany.lab_task_2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Circle Details:");
        System.out.print("Name: ");
        String circleName = scanner.nextLine();
        System.out.print("Color: ");
        String circleColor = scanner.nextLine();
        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        scanner.nextLine();

        Shape circle = new Circle(circleName, circleColor, radius);

        System.out.println("Enter Rectangle Details:");
        System.out.print("Name: ");
        String rectName = scanner.nextLine();
        System.out.print("Color: ");
        String rectColor = scanner.nextLine();
        System.out.print("Length: ");
        double length = scanner.nextDouble();
        System.out.print("Width: ");
        double width = scanner.nextDouble();

        Shape rectangle = new Rectangle(rectName, rectColor, length, width);

        System.out.println("Shape Information:");
        circle.Display();
        System.out.println();
        rectangle.Display();

        scanner.close();
    }
}