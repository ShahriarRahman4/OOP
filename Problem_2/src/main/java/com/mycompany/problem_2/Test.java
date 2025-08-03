package com.mycompany.problem_2;

public class Test {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        books[0] = new Book("Book 1", "Author 1", 2020, "Fiction 1");
        books[1] = new Book("Book 2", "Author 2", 2021, "Fiction 2");
        books[2] = new Book("Book 3", "Author 3", 2022, "Fiction 3");

        System.out.println("Initial Book Details :");
        for (Book book : books) {
            book.displayDetails();
        }
        
        books[1]=null;
        
        System.out.println("After Removing one book : ");
         for (Book book : books) {
            book.displayDetails();
        }
        
    }
}
