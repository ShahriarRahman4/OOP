package com.mycompany.lab_task_10;

import java.util.Scanner;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryCatalog catalog = new LibraryCatalog();

    public static void main(String[] args) {
        System.out.println("Welcome to the Library Management System!");
        System.out.println("=".repeat(50));
        loadSampleBooks();
        runMainMenu();
        scanner.close();
        System.out.println("Thank you for using the Library Management System!");
    }

    private static void runMainMenu() {
        while (true) {
            displayMainMenu();
            int choice = getValidMenuChoice();
            if (choice == 9) {
                System.out.println("Exiting Library System. Goodbye!");
                break;
            }
            processMenuChoice(choice);
            System.out.println();
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("LIBRARY MANAGEMENT SYSTEM - MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Add New Book");
        System.out.println("2. Search Books by Title");
        System.out.println("3. Search Books by Author");
        System.out.println("4. Search Books by Genre");
        System.out.println("5. Borrow a Book");
        System.out.println("6. Return a Book");
        System.out.println("7. View All Books");
        System.out.println("8. View Top Borrowed Books");
        System.out.println("9. Exit System");
        System.out.println("-".repeat(50));
    }

    private static int getValidMenuChoice() {
        while (true) {
            System.out.print("Please enter your choice (1-9): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= 9) return choice;
                System.out.println("Error: Please enter a number between 1 and 9.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static void processMenuChoice(int choice) {
        switch (choice) {
            case 1: addNewBook(); break;
            case 2: searchByTitle(); break;
            case 3: searchByAuthor(); break;
            case 4: searchByGenre(); break;
            case 5: borrowBook(); break;
            case 6: returnBook(); break;
            case 7: viewAllBooks(); break;
            case 8: viewTopBorrowedBooks(); break;
            default: System.out.println("Invalid option selected.");
        }
    }

    private static void addNewBook() {
        System.out.println("\n--- ADD NEW BOOK ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();
        if (isbn.isEmpty()) { System.out.println("Error: ISBN cannot be empty."); return; }
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) { System.out.println("Error: Title cannot be empty."); return; }
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) { System.out.println("Error: Author cannot be empty."); return; }
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();
        if (genre.isEmpty()) { System.out.println("Error: Genre cannot be empty."); return; }
        int copies = getValidCopyCount();
        Book newBook = new Book(isbn, title, author, genre, copies);
        catalog.addBook(newBook);
    }

    private static void searchByTitle() {
        System.out.println("\n--- SEARCH BY TITLE ---");
        System.out.print("Enter title or keyword to search: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) { System.out.println("Error: Please enter a search keyword."); return; }
        catalog.searchByTitle(keyword);
    }

    private static void searchByAuthor() {
        System.out.println("\n--- SEARCH BY AUTHOR ---");
        System.out.print("Enter author name to search: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) { System.out.println("Error: Please enter an author name."); return; }
        catalog.searchByAuthor(author);
    }

    private static void searchByGenre() {
        System.out.println("\n--- SEARCH BY GENRE ---");
        System.out.print("Enter genre to search: ");
        String genre = scanner.nextLine().trim();
        if (genre.isEmpty()) { System.out.println("Error: Please enter a genre."); return; }
        catalog.searchByGenre(genre);
    }

    private static void borrowBook() {
        System.out.println("\n--- BORROW BOOK ---");
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine().trim();
        if (isbn.isEmpty()) { System.out.println("Error: Please enter a valid ISBN."); return; }
        catalog.borrowBook(isbn);
    }

    private static void returnBook() {
        System.out.println("\n--- RETURN BOOK ---");
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine().trim();
        if (isbn.isEmpty()) { System.out.println("Error: Please enter a valid ISBN."); return; }
        catalog.returnBook(isbn);
    }

    private static void viewAllBooks() {
        System.out.println("\n--- VIEW ALL BOOKS ---");
        catalog.showAllBooks();
    }

    private static void viewTopBorrowedBooks() {
        System.out.println("\n--- TOP BORROWED BOOKS ---");
        int topN = getValidTopNCount();
        catalog.showTopBorrowedBooks(topN);
    }

    private static int getValidCopyCount() {
        while (true) {
            System.out.print("Enter number of copies: ");
            try {
                int copies = Integer.parseInt(scanner.nextLine().trim());
                if (copies > 0) return copies;
                System.out.println("Error: Number of copies must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static int getValidTopNCount() {
        while (true) {
            System.out.print("How many top borrowed books to show? ");
            try {
                int count = Integer.parseInt(scanner.nextLine().trim());
                if (count > 0) return count;
                System.out.println("Error: Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static void loadSampleBooks() {
        System.out.println("Loading sample books...");
        catalog.addBook(new Book("978-0-7475-3269-9", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 5));
        catalog.addBook(new Book("978-0-7475-3849-3", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", 4));
        catalog.addBook(new Book("978-0-7475-4624-5", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", 6));
        catalog.addBook(new Book("978-0-7475-4625-2", "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", 7));
        catalog.addBook(new Book("978-0-7475-8105-0", "Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Fantasy", 3));
        catalog.addBook(new Book("978-0-7475-8106-7", "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy", 4));
        catalog.addBook(new Book("978-0-7475-8107-4", "Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy", 5));
        catalog.addBook(new Book("978-0-261-10235-4", "The Hobbit", "J.R.R. Tolkien", "Fantasy", 8));
        catalog.addBook(new Book("978-0-261-10237-8", "The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", 6));
        catalog.addBook(new Book("978-0-261-10238-5", "The Two Towers", "J.R.R. Tolkien", "Fantasy", 5));
        catalog.addBook(new Book("978-0-261-10239-2", "The Return of the King", "J.R.R. Tolkien", "Fantasy", 4));
        catalog.addBook(new Book("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee", "Classic", 9));
        catalog.addBook(new Book("978-0-452-28423-4", "1984", "George Orwell", "Dystopian", 7));
        catalog.addBook(new Book("978-0-14-028333-4", "Pride and Prejudice", "Jane Austen", "Romance", 6));
        catalog.addBook(new Book("978-0-14-028334-1", "Jane Eyre", "Charlotte Brontë", "Romance", 5));
        catalog.addBook(new Book("978-0-14-028335-8", "Wuthering Heights", "Emily Brontë", "Romance", 4));
        catalog.addBook(new Book("978-0-14-028336-5", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 8));
        catalog.addBook(new Book("978-0-14-028337-2", "Animal Farm", "George Orwell", "Allegory", 6));
        catalog.addBook(new Book("978-0-14-028338-9", "Lord of the Flies", "William Golding", "Allegory", 5));
        catalog.addBook(new Book("978-0-14-028339-6", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 7));
        catalog.addBook(new Book("978-0-14-028340-2", "Brave New World", "Aldous Huxley", "Dystopian", 6));
        catalog.addBook(new Book("978-0-14-028341-9", "Fahrenheit 451", "Ray Bradbury", "Dystopian", 5));
        System.out.println("Sample books loaded successfully!");
        System.out.println("Total books in catalog: " + catalog.getTotalBooks());
        System.out.println("Total available copies: " + catalog.getTotalAvailableCopies());
    }
}
