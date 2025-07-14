
package com.mycompany.practice_constructor;

//Write a Java program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:
//
//One constructor takes title and author as parameters.
//The other constructor takes title, author, and price as parameters.
//Print the values of the variables for each constructor

public class Book {
    String title;
    String author;
    double price;
    
    Book(String title,String author)
    {
        this.title=title;
        this.author=author;
    }
    
    Book(String title,String author,double price)
    {
        this.title=title;
        this.author=author;
        this.price=price;
    }
    
}
