package com.mycompany.lab_task_4;

public class NonFiction extends Book {
    String subject;
    int edition;
    
    public NonFiction(String title, String author, double price, String subject, int edition) {
        super(title, author, price);
        this.subject = subject;
        this.edition = edition;
    }
    
    
    void Display() {
        super.Display();
        System.out.println("Subject : " + subject);
        System.out.println("Edition : " + edition);
    }
}