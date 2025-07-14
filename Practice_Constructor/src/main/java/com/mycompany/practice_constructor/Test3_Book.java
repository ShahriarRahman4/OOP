
package com.mycompany.practice_constructor;


public class Test3_Book {
    
    public static void main(String[] args) {
        Book ob1 = new Book("HP","JK_RoWling");
        Book ob2 = new Book("Dracula","Bram_Stoker",1500);
    
    
        System.out.println("Book Name : "+ob1.title);
        System.out.println("Author Name : "+ob1.author);
        
        System.out.println("Book Name : "+ob2.title);
        System.out.println("Author Name : "+ob2.author);
        System.out.println("Price : "+ob2.price);
    }
    
}
