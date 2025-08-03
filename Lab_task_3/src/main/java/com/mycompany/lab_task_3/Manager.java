
package com.mycompany.lab_task_3;


public class Manager extends Employee {
    
    int YExperience;
    double salary;
    double bonus;
    
    
    public Manager(String name, String id,int YExperience ,double salary,double bonus)
    {
        
        super(name,id);
        this.YExperience=YExperience;
        
        this.bonus=bonus;
        this.salary = salary+(salary/100)*bonus;
    }
    
    void Display()
    {
        super.Display();
        System.out.println("Years of expperience : "+YExperience);
        System.out.println("Salary :"+salary);
        
    }
    
}
