
package com.mycompany.final_keyword;


public class University {
    
    final String uni  = "ULAB";
    static final int fee;
    
    static
    {
        fee=789000;
    }
    
    void Display()
    {
        System.out.println("University name: "+uni);
        System.out.println("Fees :"+fee);
    }
    
}
