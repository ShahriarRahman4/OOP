package com.mycompany.lab_task_10;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryCatalog {

    private Map<String, Book> booksByISBN = new HashMap<>();
    private Map<String, List<Book>> booksByAuthor = new HashMap<>();
    private Map<String, List<Book>> booksByGenre = new HashMap<>();

    public void addBook(Book book) {
        String isbn = book.getIsbn();
        if (booksByISBN.containsKey(isbn)) {
            booksByISBN.get(isbn).addCopies(book.getCopyCount());
            System.out.println("Added more copies of existing book.");
        } else {
            booksByISBN.put(isbn, book);
            booksByAuthor.computeIfAbsent(book.getAuthor().toLowerCase(), k -> new ArrayList<>()).add(book);
            booksByGenre.computeIfAbsent(book.getGenre().toLowerCase(), k -> new ArrayList<>()).add(book);
            System.out.println("New book added.");
        }
    }

    public void searchByTitle(String keyword) {
        System.out.println("Search Results (Title):");
        for (Book book : booksByISBN.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Search Results (Author):");
        List<Book> results = booksByAuthor.get(author.toLowerCase());
        if (results != null) {
            results.forEach(System.out::println);
        } else {
            System.out.println("No books found for this author.");
        }
    }

    public void searchByGenre(String genre) {
        System.out.println("Search Results (Genre):");
        List<Book> results = booksByGenre.get(genre.toLowerCase());
        if (results != null) {
            results.forEach(System.out::println);
        } else {
            System.out.println("No books found for this genre.");
        }
    }

    public void borrowBook(String isbn) {
        Book book = booksByISBN.get(isbn);
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String isbn) {
        Book book = booksByISBN.get(isbn);
        if (book != null) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showTopBorrowedBooks(int topN) {
        System.out.println("Top " + topN + " Borrowed Books:");
        booksByISBN.values().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getBorrowCount(), b1.getBorrowCount()))
                .limit(topN)
                .forEach(System.out::println);
    }

    public void showAllBooks() {
        System.out.println("All Books in Catalog:");
        for (Book book : booksByISBN.values()) {
            System.out.println(book);
        }
    }
}
