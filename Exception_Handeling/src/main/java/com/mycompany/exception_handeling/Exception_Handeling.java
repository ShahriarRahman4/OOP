
package com.mycompany.exception_handeling;


public class Exception_Handeling {

    public static void main(String[] args) {
        
        try
        {
           int x =10;
           int y = 0;
           int result = x/y;
           System.out.println("Result = "+result);
           
            
        }
        
        catch(ArithmeticException e1)
        {
            System.out.println("Arithmetic Exception");
        }
        
        catch(Exception e2)
        {
            System.out.println("Exception ");
        }
        
        finally
        {
            System.out.println("Last line of the program");
        }
                
    }
}
