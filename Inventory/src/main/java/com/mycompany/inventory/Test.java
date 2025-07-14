
package com.mycompany.inventory;


public class Test {
    public static void main(String[] args) {
        
        Inventory ob1 = new Inventory("Samsung",21000,"Vietnam");
         Inventory ob2 = new Inventory("VIVO",17000,"China");
          Inventory ob3 = new Inventory("Nokia",22000,"Philipine");
          
          
          ob1.Display();
          ob2.Display();
          ob3.Display();
          
          System.out.println("Total Device : "+ob1.totalDevice);
        
        
    }
    
}
