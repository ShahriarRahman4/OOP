
package com.mycompany.library;


public class Test {
    
     public static void main(String[] args) {
        LibraryMember member1 = new LibraryMember();
        LibraryMember member2 = new LibraryMember();

       
        member1.borrowBook();
        member1.borrowBook();

        
        member2.borrowBook();

        System.out.println("\n--- Member 1 Info ---");
        member1.Display();

        System.out.println("\n--- Member 2 Info ---");
        member2.Display();
  
        
        
}
