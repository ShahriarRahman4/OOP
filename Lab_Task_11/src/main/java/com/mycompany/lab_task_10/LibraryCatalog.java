package com.mycompany.lab_task_10;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryCatalog {
    private Map<String, Book> booksByISBN = new HashMap<>();
    private Map<String, List<Book>> booksByAuthor = new HashMap<>();
    private Map<String, List<Book>> booksByGenre = new HashMap<>();
    private Map<String, List<Book>> booksByTitle = new HashMap<>();

    public void addBook(Book book) {
        String isbn = book.getIsbn();
        if (booksByISBN.containsKey(isbn)) {
            Book existingBook = booksByISBN.get(isbn);
            existingBook.addCopies(book.getAvailableCopies());
            System.out.println("Added more copies of existing book: '" + book.getTitle() + "'");
        } else {
            booksByISBN.put(isbn, book);
            String authorKey = book.getAuthor().toLowerCase();
            String genreKey = book.getGenre().toLowerCase();
            String titleKey = book.getTitle().toLowerCase();
            booksByAuthor.computeIfAbsent(authorKey, k -> new ArrayList<>()).add(book);
            booksByGenre.computeIfAbsent(genreKey, k -> new ArrayList<>()).add(book);
            booksByTitle.computeIfAbsent(titleKey, k -> new ArrayList<>()).add(book);
            System.out.println("New book added successfully: '" + book.getTitle() + "'");
        }
    }

    public void searchByTitle(String titleOrKeyword) {
        if (titleOrKeyword == null || titleOrKeyword.trim().isEmpty()) {
            System.out.println("Error: Please provide a valid search keyword.");
            return;
        }
        String key = titleOrKeyword.toLowerCase();
        System.out.println("Search Results for Title: '" + titleOrKeyword + "'");
        System.out.println("=".repeat(50));
        List<Book> exact = booksByTitle.get(key);
        if (exact != null && !exact.isEmpty()) {
            exact.forEach(b -> { System.out.println(b); System.out.println("-".repeat(30)); });
            return;
        }
        List<Book> results = booksByISBN.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(key))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("No books found matching '" + titleOrKeyword + "'");
        } else {
            results.forEach(b -> { System.out.println(b); System.out.println("-".repeat(30)); });
        }
    }

    public void searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Please provide a valid author name.");
            return;
        }
        System.out.println("Search Results for Author: '" + author + "'");
        System.out.println("=".repeat(50));
        List<Book> results = booksByAuthor.get(author.toLowerCase());
        if (results != null && !results.isEmpty()) {
            results.forEach(b -> { System.out.println(b); System.out.println("-".repeat(30)); });
        } else {
            System.out.println("No books found for author: '" + author + "'");
        }
    }

    public void searchByGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            System.out.println("Error: Please provide a valid genre.");
            return;
        }
        System.out.println("Search Results for Genre: '" + genre + "'");
        System.out.println("=".repeat(50));
        List<Book> results = booksByGenre.get(genre.toLowerCase());
        if (results != null && !results.isEmpty()) {
            results.forEach(b -> { System.out.println(b); System.out.println("-".repeat(30)); });
        } else {
            System.out.println("No books found for genre: '" + genre + "'");
        }
    }

    public void borrowBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: Please provide a valid ISBN.");
            return;
        }
        Book book = booksByISBN.get(isbn);
        if (book != null) {
            boolean success = book.borrowBook();
            if (!success) System.out.println("Borrowing failed for book: '" + book.getTitle() + "'");
        } else {
            System.out.println("Error: Book with ISBN '" + isbn + "' not found in catalog.");
        }
    }

    public void returnBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: Please provide a valid ISBN.");
            return;
        }
        Book book = booksByISBN.get(isbn);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Error: Book with ISBN '" + isbn + "' not found in catalog.");
        }
    }

    public void showTopBorrowedBooks(int topN) {
        if (topN <= 0) {
            System.out.println("Error: Please provide a positive number.");
            return;
        }
        System.out.println("Top " + topN + " Most Borrowed Books:");
        System.out.println("=".repeat(50));
        List<Book> topBooks = booksByISBN.values().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getTotalBorrowed(), b1.getTotalBorrowed()))
                .limit(topN)
                .collect(Collectors.toList());
        if (topBooks.isEmpty()) {
            System.out.println("No books found in catalog.");
        } else {
            for (int i = 0; i < topBooks.size(); i++) {
                Book book = topBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + " (Borrowed: " + book.getTotalBorrowed() + " times)");
            }
        }
    }

    public void showAllBooks() {
        System.out.println("Complete Library Catalog:");
        System.out.println("=".repeat(50));
        if (booksByISBN.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            int bookNumber = 1;
            for (Book book : booksByISBN.values()) {
                System.out.println("Book #" + bookNumber + ":");
                System.out.println(book);
                System.out.println("-".repeat(30));
                bookNumber++;
            }
            System.out.println("Total books in catalog: " + booksByISBN.size());
        }
    }

    public int getTotalBooks() { return booksByISBN.size(); }

    public int getTotalAvailableCopies() {
        return booksByISBN.values().stream().mapToInt(Book::getAvailableCopies).sum();
    }
}
