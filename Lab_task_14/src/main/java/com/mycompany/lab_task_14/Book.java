
package com.mycompany.lab_task_14;


public class Book extends Product implements Discount  {
     private String author;
    
    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }
    
    public double getDiscount() {
        return price * 0.30;
    }
    
    public void showInfo() {
        System.out.println("Book: " + name);
        System.out.println("Price: " + price);
        System.out.println("Author: " + author);
        System.out.println("Discount: " + getDiscount());
    }

    
}
