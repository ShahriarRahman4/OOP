
package com.mycompany.practice_constructor;


public class Classroom {
    
    String className;
    String[] students;
    
    Classroom(String className , String[] students)
    {
        this.className = className;
        this.students = students;
    }
    
    
    void Display()
    {
        System.out.println("Class Name : "+className);
        System.out.println("Students : ");
        
        for(String student : students)
        {
            System.out.println(student+" ");
        }
    }
    
}
