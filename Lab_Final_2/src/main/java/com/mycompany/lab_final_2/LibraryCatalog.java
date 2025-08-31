package com.mycompany.lab_final_2;

import javax.swing.*;
import java.util.*;

public class LibraryCatalog {

    HashMap<String, Book> catalogByISBN = new HashMap<>();
    HashMap<String, ArrayList<Book>> catalogByAuthor = new HashMap<>();
    HashMap<String, ArrayList<Book>> catalogByGenre = new HashMap<>();
    private JTextArea outputArea;

    public void setOutputArea(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    private void appendOutput(String text) {
        if (outputArea != null) {
            outputArea.append(text + "\n");
        } else {
            System.out.println(text);
        }
    }

    private String createHeader() {
        return String.format("%-15s | %-30s | %-25s | %-20s | %-8s | %-10s",
                "ISBN", "Title", "Author", "Genre", "Copies", "Borrowed");
    }

    private String createSeparator() {
        return "-".repeat(120);
    }

    private String formatBook(Book book) {
        return String.format("%-15s | %-30s | %-25s | %-20s | %-8s | %-10s",
                book.isbn,
                book.title.length() > 28 ? book.title.substring(0, 25) + "..." : book.title,
                book.author.length() > 23 ? book.author.substring(0, 20) + "..." : book.author,
                book.genre.length() > 18 ? book.genre.substring(0, 15) + "..." : book.genre,
                book.totalCopies,
                book.borrowCount);
    }

    public void loadFromSource(AbstractDataLoader loader) {
        loader.connect();
        List<Book> books = loader.loadBooks();
        for (Book book : books) {
            addBook(book);
        }
        loader.disconnect();
        appendOutput("Loaded " + books.size() + " books from data source.");
    }

    public void addBook(Book book) {
        String isbn = book.isbn;

        if (catalogByISBN.containsKey(isbn)) {
            Book existing = catalogByISBN.get(isbn);
            existing.totalCopies += book.totalCopies;
            appendOutput("Added more copies of existing book.");
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

            appendOutput("New book added successfully!");
        }
    }

    public void searchByTitle(String keyword) {
        appendOutput("SEARCH RESULTS BY TITLE: " + keyword.toUpperCase());
        appendOutput(createSeparator());
        appendOutput(createHeader());
        appendOutput(createSeparator());

        boolean found = false;
        for (Book b : catalogByISBN.values()) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                appendOutput(formatBook(b));
                found = true;
            }
        }

        if (!found) {
            appendOutput("No books found with that title.");
        } else {
            appendOutput(createSeparator());
        }
    }

    public void searchByAuthor(String author) {
        appendOutput("SEARCH RESULTS BY AUTHOR: " + author.toUpperCase());
        appendOutput(createSeparator());
        appendOutput(createHeader());
        appendOutput(createSeparator());

        String key = author.toLowerCase();
        if (catalogByAuthor.containsKey(key)) {
            for (Book b : catalogByAuthor.get(key)) {
                appendOutput(formatBook(b));
            }
            appendOutput(createSeparator());
        } else {
            appendOutput("No books found for this author.");
        }
    }

    public void searchByGenre(String genre) {
        appendOutput("SEARCH RESULTS BY GENRE: " + genre.toUpperCase());
        appendOutput(createSeparator());
        appendOutput(createHeader());
        appendOutput(createSeparator());

        String key = genre.toLowerCase();
        if (catalogByGenre.containsKey(key)) {
            for (Book b : catalogByGenre.get(key)) {
                appendOutput(formatBook(b));
            }
            appendOutput(createSeparator());
        } else {
            appendOutput("No books found for this genre.");
        }
    }

    public void borrowBook(String isbn) {
        if (catalogByISBN.containsKey(isbn)) {
            String result = catalogByISBN.get(isbn).borrowBook();
            appendOutput("BORROW OPERATION:");
            appendOutput(createSeparator());
            appendOutput("ISBN: " + isbn);
            appendOutput("Result: " + result);
            appendOutput(createSeparator());
        } else {
            appendOutput("BORROW OPERATION:");
            appendOutput(createSeparator());
            appendOutput("ISBN: " + isbn);
            appendOutput("Result: Book not found.");
            appendOutput(createSeparator());
        }
    }

    public void returnBook(String isbn) {
        if (catalogByISBN.containsKey(isbn)) {
            String result = catalogByISBN.get(isbn).returnBook();
            appendOutput("RETURN OPERATION:");
            appendOutput(createSeparator());
            appendOutput("ISBN: " + isbn);
            appendOutput("Result: " + result);
            appendOutput(createSeparator());
        } else {
            appendOutput("RETURN OPERATION:");
            appendOutput(createSeparator());
            appendOutput("ISBN: " + isbn);
            appendOutput("Result: Book not found.");
            appendOutput(createSeparator());
        }
    }

    public void showTopBorrowed(int topN) {
        ArrayList<Book> allBooks = new ArrayList<>(catalogByISBN.values());
        Collections.sort(allBooks, (b1, b2) -> b2.borrowCount - b1.borrowCount);

        appendOutput("TOP " + topN + " MOST BORROWED BOOKS:");
        appendOutput(createSeparator());
        appendOutput(createHeader());
        appendOutput(createSeparator());

        for (int i = 0; i < topN && i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            appendOutput(String.format("%-3s | %s", (i + 1), formatBook(book)));
        }

        appendOutput(createSeparator());
    }

    public void showAllBooks() {
        appendOutput("COMPLETE LIBRARY CATALOG:");
        appendOutput(createSeparator());
        appendOutput(createHeader());
        appendOutput(createSeparator());

        if (catalogByISBN.isEmpty()) {
            appendOutput("No books in catalog.");
        } else {
            for (Book b : catalogByISBN.values()) {
                appendOutput(formatBook(b));
            }
            appendOutput(createSeparator());
            appendOutput("Total Books: " + catalogByISBN.size());
        }
    }
}
