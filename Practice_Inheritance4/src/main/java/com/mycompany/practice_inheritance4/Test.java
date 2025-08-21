
package com.mycompany.practice_inheritance4;


public class Test {
    public static void main(String[] args)
    {
        Employee ob1 = new Employee(40000);
        HRmanager ob2 = new HRmanager(50000);
        
        ob2.work();
        ob2.addemployee();
        
        System.out.println("HR Manager Salary :"+ob2.getSalary());
        ob2.work();
        ob2.addemployee();
        
        System.out.println("Employee Salary :"+ob1.getSalary());
        ob1.work();
    }
    
}
