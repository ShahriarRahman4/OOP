
package com.mycompany.oop_1;

public class Teacher {
    
    String name,gender;
    int number;
    
    //Deafult Constructor
    Teacher()
    {
        System.out.println("No Value");
    }
    
    Teacher(String n,String g,int p)
    {
        name = n;
        gender = g;
        number = p;
    }
    
   /* void setInformation(String n , String m ,int ph)
    {
        name = n;
        gender = m;
        number =ph;
    }*/
    
    void displayInformation()
    {
        System.out.println("Name :"+name);
        System.out.println("Gender : "+gender);
        System.out.println("Phone :"+number);
    }
            
    
}
