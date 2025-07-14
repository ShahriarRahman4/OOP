
package com.mycompany.practice_constructor;

//Write a Java program to create a class called Student with instance variables studentId, studentName, and grade.
//Implement a default constructor and a parameterized constructor that takes all three instance variables.
//Use constructor chaining to initialize the variables. Print the values of the variables.

public class Student {
    
    double studentId;
    String studentName;
    String grade;
    
    //Default constructor
     Student()
    {
        this(0,"Unknown","None");
    }
     
    //Parameterized Constructor
     
     Student(double studentId,String studentName,String grade)
     {
         this.studentId=studentId;
         this.studentName=studentName;
         this.grade=grade;
     }
     
     void Display1()
     {
         System.out.println("ID : "+studentId);
         System.out.println("Student Name : "+studentName);
         System.out.println("Grade : "+grade);
         
     }
     
}
