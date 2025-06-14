
package com.mycompany.overloading_constructor;


public class Test
{
    public static void main(String[] args)
    {
        Teacher teacher1 =new Teacher();
        teacher1.displayInformation();
        Teacher teacher2 =new Teacher("Rifat","Male");
        teacher2.displayInformation();
        
        Teacher teacher3 =new Teacher("Shifat","Male",14401);
        teacher3.displayInformation();
        
        
        
        
    }
    
}
