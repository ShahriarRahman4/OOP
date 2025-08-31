package com.mycompany.lab_final;

import java.util.Scanner;
import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();

        loadSampleBooks(catalog);

        System.out.println("Would you like to load books from a file? (y/n)");
        String response = sc.nextLine().trim();
        if (response.equalsIgnoreCase("y")) {
            boolean fileLoaded = false;
            while (!fileLoaded) {
                System.out.print("Enter file path (or 'cancel' to skip): ");
                String filePath = sc.nextLine().trim();

                if (filePath.equalsIgnoreCase("cancel")) {
                    break;
                }

                FileDataLoader fileLoader = new FileDataLoader(filePath);
                fileLoader.connect();
                List<Book> loadedBooks = fileLoader.loadBooks();

                if (!loadedBooks.isEmpty()) {
                    for (Book book : loadedBooks) {
                        catalog.addBook(book);
                    }
                    fileLoaded = true;
                } else {
                    System.out.println("No books were loaded from the file. Would you like to try a different file? (y/n)");
                    String tryAgain = sc.nextLine().trim();
                    if (!tryAgain.equalsIgnoreCase("y")) {
                        break;
                    }
                }
                fileLoader.disconnect();
            }
        }

        while (true) {
            System.out.println("\nLibrary Menu : ");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Search by Genre");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Show All Books");
            System.out.println("8. Show Top Borrowed");
            System.out.println("9. Load from File");
            System.out.println("10. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1-10.");
                sc.nextLine(); 
                continue;
            }
            sc.nextLine();

            if (choice == 1) {
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                System.out.print("Genre: ");
                String genre = sc.nextLine();
                System.out.print("Copies: ");
                try {
                    int copies = sc.nextInt();
                    sc.nextLine();
                    catalog.addBook(new Book(isbn, title, author, genre, copies));
                } catch (Exception e) {
                    System.out.println("Invalid number for copies. Book not added.");
                    sc.nextLine();
                }

            } else if (choice == 2) {
                System.out.print("Enter title keyword: ");
                catalog.searchByTitle(sc.nextLine());

            } else if (choice == 3) {
                System.out.print("Enter author name: ");
                catalog.searchByAuthor(sc.nextLine());

            } else if (choice == 4) {
                System.out.print("Enter genre: ");
                catalog.searchByGenre(sc.nextLine());

            } else if (choice == 5) {
                System.out.print("Enter ISBN: ");
                catalog.borrowBook(sc.nextLine());

            } else if (choice == 6) {
                System.out.print("Enter ISBN: ");
                catalog.returnBook(sc.nextLine());

            } else if (choice == 7) {
                catalog.showAllBooks();

            } else if (choice == 8) {
                System.out.print("Show top N: ");
                try {
                    int topN = sc.nextInt();
                    catalog.showTopBorrowed(topN);
                } catch (Exception e) {
                    System.out.println("Invalid number.");
                    sc.nextLine();
                }

            } else if (choice == 9) {
                System.out.print("Enter file path: ");
                String filePath = sc.nextLine();
                FileDataLoader fileLoader = new FileDataLoader(filePath);
                fileLoader.connect();
                List<Book> loadedBooks = fileLoader.loadBooks();
                if (!loadedBooks.isEmpty()) {
                    for (Book book : loadedBooks) {
                        catalog.addBook(book);
                    }
                }
                fileLoader.disconnect();

            } else if (choice == 10) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please choose between 1-10.");
            }
        }

        sc.close();
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
