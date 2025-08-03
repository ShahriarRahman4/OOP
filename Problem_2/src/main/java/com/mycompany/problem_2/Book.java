
package com.mycompany.problem_2;


public class Book {
    private String title;
    private String  author;
    private int year;
    private String genre;
    
    
    
    public Book(String title,String author,int year, String genre)
    {
        this.title=title;
        this.author=author;
        this.year=year;
        this.genre=genre;
    }
    
    public void displayDetails()
    {
        System.out.println("Title : "+title);
        System.out.println("Author :"+author);
        System.out.println("Year : "+year);
        System.out.println("Genre : "+genre);
        System.out.println();
    }
    
    
    
    
}
