
package com.mycompany.encapsulation;


public class Person {
        
    
    private String name="Shahriar";
    private int age=13;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int agemultiplier(int v)
    {
        return v*age;
    }
    
    
    
 
   
    
    
}

