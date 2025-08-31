package com.mycompany.lab_final_2;

import java.util.Scanner;
import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryGUI.main(args);
    }

    public static void loadSampleBooks(LibraryCatalog catalog) {
        catalog.addBook(new Book("97", "The Odyssey", "Homer", "Epic", 5));
        catalog.addBook(new Book("971", "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", 7));
        catalog.addBook(new Book("972", "The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", 4));
        catalog.addBook(new Book("973", "The Road", "Cormac McCarthy", "Post-Apoc", 3));
        catalog.addBook(new Book("974", "To Kill a Mockingbird", "Harper Lee", "Classic", 6));
        catalog.addBook(new Book("975", "1984", "George Orwell", "Dystopian", 8));
        catalog.addBook(new Book("976", "Jane Eyre", "Charlotte Brontë", "Romance", 2));
        catalog.addBook(new Book("977", "The Iliad", "Homer", "Epic", 3));
        catalog.addBook(new Book("978", "Eloquent JavaScript", "Marijn Haverbeke", "Programming", 10));
        catalog.addBook(new Book("979", "Effective Java", "Joshua Bloch", "Programming", 5));
    }
}
