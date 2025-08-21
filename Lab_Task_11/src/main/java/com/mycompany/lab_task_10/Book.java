package com.mycompany.lab_task_10;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int availableCopies;
    private int totalBorrowed;

    public Book(String isbn, String title, String author, String genre, int initialCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = initialCopies;
        this.totalBorrowed = 0;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getAvailableCopies() { return availableCopies; }
    public int getTotalBorrowed() { return totalBorrowed; }
    public int getCopyCount() { return availableCopies; }
    public int getBorrowCount() { return totalBorrowed; }

    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            totalBorrowed++;
            System.out.println("Book '" + title + "' borrowed successfully.");
            return true;
        } else {
            System.out.println("Sorry, no copies of '" + title + "' are currently available.");
            return false;
        }
    }

    public void returnBook() {
        availableCopies++;
        System.out.println("Book '" + title + "' returned successfully.");
    }

    public void addCopies(int additionalCopies) {
        if (additionalCopies > 0) {
            availableCopies += additionalCopies;
            System.out.println("Added " + additionalCopies + " copies of '" + title + "'.");
        } else {
            System.out.println("Error: Cannot add negative or zero copies.");
        }
    }

    public boolean isAvailable() { return availableCopies > 0; }

    @Override
    public String toString() {
        return String.format("Book Details:%n  ISBN: %s%n  Title: %s%n  Author: %s%n  Genre: %s%n  Available Copies: %d%n  Total Times Borrowed: %d", isbn, title, author, genre, availableCopies, totalBorrowed);
    }
}
