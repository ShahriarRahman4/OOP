
package com.mycompany.static_variable2;


public class Static_Variable {
    static int count =0 ;
    Static_Variable()
    {
        count++; 
    }
    
    void total()
    {
        System.out.println("Total student : "+count);
    }
    
}
