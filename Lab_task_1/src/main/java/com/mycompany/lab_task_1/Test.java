package com.mycompany.lab_task_1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Car Details:");
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Color: ");
        String carColor = scanner.nextLine();
        System.out.print("Price: ");
        double carPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Registration Number: ");
        String carRegNum = scanner.nextLine();

        Vehicle car = new Car(carBrand, carModel, carColor, carPrice, carRegNum);

        System.out.println("Enter Motorcycle Details:");
        System.out.print("Brand: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Model: ");
        String bikeModel = scanner.nextLine();
        System.out.print("Color: ");
        String bikeColor = scanner.nextLine();
        System.out.print("Price: ");
        double bikePrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Number Plate: ");
        String bikePlate = scanner.nextLine();
        System.out.print("Tank Capacity: ");
        String bikeTank = scanner.nextLine();

        Vehicle motorcycle = new Motorcycle(bikeBrand, bikeModel, bikeColor, bikePrice, bikePlate, bikeTank);

        System.out.println("Car Details:");
        car.Display();
        System.out.println();
        System.out.println();
        System.out.println("Motorcycle Details:");
        motorcycle.Display();

        scanner.close();
    }
}