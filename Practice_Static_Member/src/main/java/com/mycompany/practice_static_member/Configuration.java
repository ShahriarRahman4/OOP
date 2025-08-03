
package com.mycompany.practice_static_member;


public class Configuration {
    static String configValue;
    
    static{
        configValue="Default Config Value";
        System.out.println("Static block executed:Config Value initialized");
        
    }
    
    
    public static void main(String[] args)
    {
        System.out.println("Config Value :" +configValue);
    }
    
}
