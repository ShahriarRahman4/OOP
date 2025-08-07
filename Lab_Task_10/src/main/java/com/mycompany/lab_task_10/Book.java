package com.mycompany.lab_task_10;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int copyCount;
    private int borrowCount;

    public Book(String isbn, String title, String author, String genre, int copyCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.copyCount = copyCount;
        this.borrowCount = 0;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void borrowBook() {
        if (copyCount > 0) {
            borrowCount++;
            copyCount--;
            System.out.println("Borrowed successfully.");
        } else {
            System.out.println("No copies available.");
        }
    }

    public void returnBook() {
        copyCount++;
    }

    public void addCopies(int count) {
        if (count > 0) {
            copyCount += count;
        }
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title
                + ", Author: " + author + ", Genre: " + genre
                + ", Copies: " + copyCount + ", Borrowed: " + borrowCount;
    }
}
