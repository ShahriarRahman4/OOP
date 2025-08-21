package com.mycompany.lab_task_10;

public class Book {

    String isbn;
    String title;
    String author;
    String genre;
    int totalCopies;
    int borrowCount;

    public Book(String isbn, String title, String author, String genre, int totalCopies) 
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.borrowCount = 0;
    }

    public void borrowBook() 
    {
        if (totalCopies > 0) 
        {
            totalCopies--;
            borrowCount++;
            System.out.println("Borrowed successfully!");
        } 
        else
        {
            System.out.println("No copies available.");
        }
    }

    public void returnBook() {
        totalCopies++;
        System.out.println("Book returned.");
    }

    public String Display() 
    {
        return isbn + " | " + title + " | " + author + " | " + genre
                + " | Copies: " + totalCopies + " | Borrowed: " + borrowCount;
    }
}
