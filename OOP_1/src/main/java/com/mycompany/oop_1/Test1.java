
package com.mycompany.oop_1;

public class Test1 {
    public static void main(String[] args)
    {
        Teacher teacher1 = new Teacher("Shahriar","male",17);
        
        //teacher1.setInformation("Shahriar","male",17);
        
        /*teacher1.name="Shahriar";
        teacher1.gender="Male";
        teacher1.number=17;*/
        
        
        teacher1.displayInformation();
        
        Teacher teacher2 = new Teacher("Shifat","male",16);
        //teacher2.setInformation("Shifat","male",16);
        
        /*teacher2.name="Shifat";
        teacher2.gender="Male";
        teacher2.number=16;*/
        
        teacher2.displayInformation();
        
        Teacher teacher3=new Teacher();
        teacher3.displayInformation();
    }
    
}
