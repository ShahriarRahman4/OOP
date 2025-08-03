
package com.mycompany.lab_task_3;


public class Employee {
    
    String name;
    String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
        
    }
    
    void Display()
    {
        System.out.println("Name :"+name);
        System.out.println("ID :"+id);
        
    }
    
    
}
