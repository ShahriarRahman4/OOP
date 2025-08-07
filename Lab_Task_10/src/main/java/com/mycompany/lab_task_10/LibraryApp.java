package com.mycompany.lab_task_10;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();

        loadSampleBooks(catalog);

        while (true) {
            System.out.println("Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Search by Genre");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Show All Books");
            System.out.println("8. Show Top Borrowed Books");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();
                    Book newBook = new Book(isbn, title, author, genre, copies);
                    catalog.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter title keyword: ");
                    String keyword = sc.nextLine();
                    catalog.searchByTitle(keyword);
                    break;

                case 3:
                    System.out.print("Enter author name: ");
                    String auth = sc.nextLine();
                    catalog.searchByAuthor(auth);
                    break;

                case 4:
                    System.out.print("Enter genre: ");
                    String gen = sc.nextLine();
                    catalog.searchByGenre(gen);
                    break;

                case 5:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowISBN = sc.nextLine();
                    catalog.borrowBook(borrowISBN);
                    break;

                case 6:
                    System.out.print("Enter ISBN to return: ");
                    String returnISBN = sc.nextLine();
                    catalog.returnBook(returnISBN);
                    break;

                case 7:
                    catalog.showAllBooks();
                    break;

                case 8:
                    System.out.print("How many top borrowed books to show? ");
                    int n = sc.nextInt();
                    catalog.showTopBorrowedBooks(n);
                    break;

                case 9:
                    System.out.println("Exiting Library System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
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
        System.out.println("Sample books loaded into the catalog.");
    }
}
