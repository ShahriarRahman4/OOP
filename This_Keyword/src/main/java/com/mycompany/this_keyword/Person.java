
package com.mycompany.this_keyword;


public class Person {
    
    String name;
    int age;
    String hairColor;
    
    Person(String name,int age)  
    {
        this.name=name;
        this.age=age;
    }
    
    Person(String name,int age,String hairColor)
    {
        this(name,age);
        this.hairColor=hairColor;
    }
    
    void Display()
    {
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Hair Color :"+hairColor);
    }
    
}
