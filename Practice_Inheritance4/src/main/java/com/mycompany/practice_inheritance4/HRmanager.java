
package com.mycompany.practice_inheritance4;


public class HRmanager extends Employee{
    
    public HRmanager(int salary)
    {
        super(salary);
    }
    
    public void work()
    {
        System.out.println("Managing Employess");
    }
    
    public void addemployee()
    {
        System.out.println("Adding new Employee");
    }
    
}
