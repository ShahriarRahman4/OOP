
package com.mycompany.lab_task_3;


public class Engineer extends Employee {
    
    String Skills;
     double salary;
    double bonus;
    
    
    public Engineer(String name, String id,String skills ,double salary,double bonus)
    {
        
        super(name,id);
        this.Skills=Skills;
        
        this.bonus=bonus;
        this.salary = salary+(salary/100)*bonus;
    }
    
    void Display()
    {
        super.Display();
        System.out.println("Skills : "+Skills);
        System.out.println("Salary :"+salary);
        
    }
    
}
