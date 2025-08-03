package com.mycompany.lab_task_4;

public class FictionBook extends Book {
    String publDate;
    String details;
    
    public FictionBook(String title, String author, double price, String publDate, String details) {
        super(title, author, price);
        this.publDate = publDate;
        this.details = details;
    }
    
   
    void Display() {
        super.Display();
        System.out.println("Publish Date : " + publDate);
        System.out.println("Details : " + details);
    }
}