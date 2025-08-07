package com.mycompany.lab_task_7;

import java.util.*;
import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private int year;
    static String genre;
    static ArrayList<Book> books = new ArrayList<>();

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        books.add(this);
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
    }

    public static void displayTotalBooks() {
        System.out.println("Total books: " + books.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book.genre = "Fiction";

        System.out.println("Enter number of books:");
        int x = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < x; i++) {
            System.out.print("Enter title for book " + (i + 1) + ": ");
            String title = scanner.nextLine();
            System.out.print("Enter author for book " + (i + 1) + ": ");
            String author = scanner.nextLine();
            System.out.print("Enter year for book " + (i + 1) + ": ");
            int year = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            new Book(title, author, year);
        }

        for (Book book : books) {
            book.displayDetails();
            System.out.println();
        }

        Book.displayTotalBooks();
        scanner.close();
    }
}
