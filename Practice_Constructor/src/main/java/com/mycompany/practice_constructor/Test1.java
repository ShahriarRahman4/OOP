
package com.mycompany.practice_constructor;



public class Test1 {
    public static void main(String[] args) {
        Cat ob1 =  new Cat();
        ob1.setName("Unknown");
        ob1.setAge(0);
        
        
//        ob1.Display();
        
        System.out.println("Name : "+ob1.getName());
        System.out.println("Age : "+ob1.getAge());
        
    }
    
}
