# Library Management System

A comprehensive Java-based library management system that allows users to manage books, search through catalogs, and track borrowing activities.

## Features

### 📚 Book Management
- **Add New Books**: Add books with ISBN, title, author, genre, and initial copy count
- **Inventory Tracking**: Track available copies and total borrowing count for each book
- **Copy Management**: Add more copies to existing books

### 🔍 Search Capabilities
- **Search by Title**: Find books using keywords in titles
- **Search by Author**: Browse all books by a specific author
- **Search by Genre**: Discover books within specific genres
- **Case-insensitive**: All searches work regardless of capitalization

### 📖 Borrowing System
- **Borrow Books**: Check out available copies
- **Return Books**: Return borrowed copies
- **Availability Check**: See which books are currently available
- **Borrowing Statistics**: Track how often each book is borrowed

### 📊 Analytics
- **Top Borrowed Books**: View the most popular books
- **Catalog Overview**: See all books in the system
- **Inventory Summary**: Total books and available copies

## How to Use

### Prerequisites
- Java 8 or higher
- Maven (for building the project)

### Running the Program

1. **Compile and Run**:
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="com.mycompany.lab_task_10.LibraryApp"
   ```

2. **Or run the JAR file directly**:
   ```bash
   java -jar target/Lab_Task_10-1.0-SNAPSHOT.jar
   ```

### Program Interface

The program provides a user-friendly console interface with the following menu options:

```
==================================================
LIBRARY MANAGEMENT SYSTEM - MAIN MENU
==================================================
1. Add New Book
2. Search Books by Title
3. Search Books by Author
4. Search Books by Genre
5. Borrow a Book
6. Return a Book
7. View All Books
8. View Top Borrowed Books
9. Exit System
--------------------------------------------------
```

### Sample Data

The system comes pre-loaded with popular books including:
- **Harry Potter series** by J.K. Rowling
- **The Lord of the Rings trilogy** by J.R.R. Tolkien
- **Classic literature** by authors like Harper Lee, George Orwell, and Jane Austen
- **Dystopian novels** and **Romance classics**

## Code Structure

### Classes

1. **`Book`** - Represents individual books with properties and operations
2. **`LibraryCatalog`** - Manages the collection of books and provides search functionality
3. **`LibraryApp`** - Main application class with user interface

### Key Improvements Made

#### Book Class
- ✅ Clear variable names (`availableCopies`, `totalBorrowed`)
- ✅ Comprehensive JavaDoc documentation
- ✅ Better method names and return values
- ✅ Input validation and error handling
- ✅ Improved `toString()` method with formatted output

#### LibraryCatalog Class
- ✅ Organized data structures with clear comments
- ✅ Enhanced search methods with better formatting
- ✅ Input validation for all methods
- ✅ Improved error messages and user feedback
- ✅ Additional utility methods

#### LibraryApp Class
- ✅ Modular design with separate methods for each operation
- ✅ Input validation and error handling
- ✅ Better user interface with clear sections
- ✅ Comprehensive sample data
- ✅ Improved menu navigation

## Example Usage

### Adding a Book
```
--- ADD NEW BOOK ---
Enter ISBN: 978-0-123456-78-9
Enter Title: The Great Adventure
Enter Author: John Smith
Enter Genre: Adventure
Enter number of copies: 3
New book added successfully: 'The Great Adventure'
```

### Searching for Books
```
--- SEARCH BY TITLE ---
Enter title keyword to search: Harry
Search Results for Title: 'Harry'
==================================================
Book Details:
  ISBN: 978-0-7475-3269-9
  Title: Harry Potter and the Philosopher's Stone
  Author: J.K. Rowling
  Genre: Fantasy
  Available Copies: 5
  Total Times Borrowed: 0
  Total Inventory: 5
------------------------------
```

### Borrowing a Book
```
--- BORROW BOOK ---
Enter ISBN of the book to borrow: 978-0-7475-3269-9
Book 'Harry Potter and the Philosopher's Stone' borrowed successfully.
```

## Benefits of the Improved System

1. **Easier to Understand**: Clear method names and comprehensive documentation
2. **Better User Experience**: Improved interface and error handling
3. **Maintainable Code**: Well-organized structure with clear separation of concerns
4. **Robust Operation**: Input validation prevents crashes and provides helpful feedback
5. **Professional Output**: Formatted display makes information easy to read

## Future Enhancements

Potential improvements could include:
- Database integration for persistent storage
- User authentication and borrowing history
- Due date tracking and late fee calculation
- Book reservations and waiting lists
- Export functionality for reports
- Web-based interface

## Contributing

Feel free to improve the code by:
- Adding new features
- Improving error handling
- Enhancing the user interface
- Adding unit tests
- Optimizing performance

## License

This project is open source and available under the MIT License. 