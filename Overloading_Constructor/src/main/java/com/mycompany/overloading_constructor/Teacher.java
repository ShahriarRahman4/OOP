 
package com.mycompany.overloading_constructor;


public class Teacher {
    
    
    String name,gender;
    int phone;
    
    Teacher()
    {
        System.out.println("NO INFORMATION");
    }
    
    Teacher(String n , String q)
    {
        name = n ;
        gender =q;
        
    }
    
    Teacher(String n, String q,int p)
    {
        name =n;
        gender =q;
        phone = p;
    }
    
    
    void displayInformation()
    {
        System.out.println("Name : "+name);
        System.out.println("Gender : "+gender);
        System.out.println("Phone : "+phone);
        
    }
    
}
