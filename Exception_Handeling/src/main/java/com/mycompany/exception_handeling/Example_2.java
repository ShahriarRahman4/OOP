
package com.mycompany.exception_handeling;

public class Example_2 {
    public static void main(String[] args)
    {
        try{
            int[] a =new int[4];
            a[4] = 10;
            
        }
        catch(ArithmeticException e1)
        {
            System.out.println("Exception 1"+e1);
        }
        catch(Exception e2)
        {
            System.out.println("Exception 2"+e2);
        }
        
        finally
        {
            System.out.println("Last liine of the Program");
        }
    }
}
