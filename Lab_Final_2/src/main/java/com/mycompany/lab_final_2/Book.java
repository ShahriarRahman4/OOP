package com.mycompany.lab_final_2;

public class Book {

    String isbn;
    String title;
    String author;
    String genre;
    int totalCopies;
    int borrowCount;

    public Book(String isbn, String title, String author, String genre, int totalCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.borrowCount = 0;
    }

    public String borrowBook() {
        if (totalCopies > 0) {
            totalCopies--;
            borrowCount++;
            return "Borrowed successfully!";
        } else {
            return "No copies available.";
        }
    }

    public String returnBook() {
        totalCopies++;
        return "Book returned.";
    }

    public String Display() {
        return isbn + " | " + title + " | " + author + " | " + genre
                + " | Copies: " + totalCopies + " | Borrowed: " + borrowCount;
    }
}
