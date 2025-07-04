
package com.mycompany.inheritance2;

public class Teacher extends Inheritance2 {
    private String qualification;
    
    public String getQualification()
    {
        return qualification;
    }
    
    public void setQualification(String qualification)
    {
        this.qualification=qualification;
    }
    
    void Display()
    {
        System.out.println(getName());
        System.out.println(getAge());
        System.out.println(getQualification());
    }
    
}
