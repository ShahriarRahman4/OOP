
package com.mycompany.practice_constructor;

    /* Write a Java program to create a class called "Cat" with instance variables name and age.
       Implement a default constructor that initializes the name to "Unknown" and the age to 0.
       Print the values of the variables */

public class Cat {
    private String name;
    private int age;
    
//    Cat()
//    {
//        name = "unknown";
//        age = 0;
//    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setAge(int age)
    {
        this.age=age;
    }
    
    public int getAge()
    {
        return age;
    }
    
//    void Display()
//    {
//        System.out.println("Name : "+name);
//        System.out.println("Age  : "+age);
//    }
    
}
