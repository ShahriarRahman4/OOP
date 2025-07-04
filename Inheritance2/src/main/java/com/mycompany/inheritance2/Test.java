
package com.mycompany.inheritance2;


public class Test {
    public static void main(String[] args)
    {
        Teacher t1 = new Teacher();
        t1.setName("Shahriar");
        t1.setAge(22);
        t1.setQualification("Student");
        
       t1.Display();
       
       Teacher t2 = new Teacher();
       t2.setName("Shifat");
       t2.setAge(30);
       t2.setQualification("Job_Holder");
       t2.Display();
        
        
        
    }
    
}
