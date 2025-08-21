package com.mycompany.lab_task_10;

import java.util.*;

public class LibraryCatalog {

    HashMap<String, Book> catalogByISBN = new HashMap<>();
    HashMap<String, ArrayList<Book>> catalogByAuthor = new HashMap<>();
    HashMap<String, ArrayList<Book>> catalogByGenre = new HashMap<>();

    public void addBook(Book book) {
        String isbn = book.isbn;

        if (catalogByISBN.containsKey(isbn)) {
            Book existing = catalogByISBN.get(isbn);
            existing.totalCopies += book.totalCopies;
            System.out.println("Added more copies of existing book.");
        } else {
            catalogByISBN.put(isbn, book);

            String authorKey = book.author.toLowerCase();
            if (!catalogByAuthor.containsKey(authorKey)) {
                catalogByAuthor.put(authorKey, new ArrayList<>());
            }
            catalogByAuthor.get(authorKey).add(book);

            String genreKey = book.genre.toLowerCase();
            if (!catalogByGenre.containsKey(genreKey)) {
                catalogByGenre.put(genreKey, new ArrayList<>());
            }
            catalogByGenre.get(genreKey).add(book);

            System.out.println("New book added.");
        }
    }

    public void searchByTitle(String keyword) {
        System.out.println("Search by Title: " + keyword);
        for (Book b : catalogByISBN.values()) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.Display());
            }
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Search by Author: " + author);
        String key = author.toLowerCase();
        if (catalogByAuthor.containsKey(key)) {
            for (Book b : catalogByAuthor.get(key)) {
                System.out.println(b.Display());
            }
        } else {
            System.out.println("No books found for this author.");
        }
    }

    public void searchByGenre(String genre) {
        System.out.println("Search by Genre: " + genre);
        String key = genre.toLowerCase();
        if (catalogByGenre.containsKey(key)) {
            for (Book b : catalogByGenre.get(key)) {
                System.out.println(b.Display());
            }
        } else {
            System.out.println("No books found for this genre.");
        }
    }

    public void borrowBook(String isbn) {
        if (catalogByISBN.containsKey(isbn)) {
            catalogByISBN.get(isbn).borrowBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String isbn) {
        if (catalogByISBN.containsKey(isbn)) {
            catalogByISBN.get(isbn).returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showTopBorrowed(int topN) {
        ArrayList<Book> allBooks = new ArrayList<>(catalogByISBN.values());
        
        Collections.sort(allBooks, (b1, b2) -> b2.borrowCount - b1.borrowCount);

        System.out.println("Top " + topN + " Borrowed Books:");
        for (int i = 0; i < topN && i < allBooks.size(); i++) {
            System.out.println(allBooks.get(i).Display());
        }
    }

    public void showAllBooks() {
        System.out.println("All Books in Catalog:");
        for (Book b : catalogByISBN.values()) {
            System.out.println(b.Display());
        }
    }
}