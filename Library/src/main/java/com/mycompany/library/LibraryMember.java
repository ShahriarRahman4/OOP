
package com.mycompany.library;


public class LibraryMember {
    
    
    
    private int booksBorrowed;
    private static int totalBooksBorrowed = 0;
    
     LibraryMember()
    {
        booksBorrowed=0;
    }
    
    
     void borrowBook()
    {
         booksBorrowed++;
         totalBooksBorrowed++;
         
         System.out.println("Book is Borrowd successfully");
    }
     
     void Display()
     {
           System.out.println("Books borrowed by this member: " + booksBorrowed);
        System.out.println("Total books borrowed by all members: " + totalBooksBorrowed);
     }
     
      public static int getTotalBooksBorrowed() {
        return totalBooksBorrowed;
    }
    
    
    
}
