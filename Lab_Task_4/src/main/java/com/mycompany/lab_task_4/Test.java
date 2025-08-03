package com.mycompany.lab_task_4;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Fiction Book Details:");
        System.out.print("Title: ");
        String fictionTitle = scanner.nextLine();
        System.out.print("Author: ");
        String fictionAuthor = scanner.nextLine();
        System.out.print("Price: ");
        double fictionPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Publish Date: ");
        String publDate = scanner.nextLine();
        System.out.print("Details: ");
        String details = scanner.nextLine();
        
        FictionBook fictionBook = new FictionBook(fictionTitle, fictionAuthor, fictionPrice, publDate, details);
        
        System.out.println();
        
        System.out.println("Enter Non-Fiction Book Details:");
        System.out.print("Title: ");
        String nonFictionTitle = scanner.nextLine();
        System.out.print("Author: ");
        String nonFictionAuthor = scanner.nextLine();
        System.out.print("Price: ");
        double nonFictionPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Edition: ");
        int edition = scanner.nextInt();
        
        NonFiction nonFictionBook = new NonFiction(nonFictionTitle, nonFictionAuthor, nonFictionPrice, subject, edition);
        
        System.out.println();
        System.out.println("Fiction Book Information:");
        fictionBook.Display();
        
        System.out.println();
        
        System.out.println("Non-Fiction Book Information:");
        nonFictionBook.Display();
        
        scanner.close();
    }
}