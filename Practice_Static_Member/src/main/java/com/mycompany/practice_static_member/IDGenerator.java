
package com.mycompany.practice_static_member;


public class IDGenerator {

static double nextID=0;
static double  generateID()
{
    nextID++;
    return nextID; 
}

public static void main(String[] args)
{
    System.out.println("Generated ID: "+IDGenerator.generateID());
    System.out.println("Generated ID: "+IDGenerator.generateID());
       System.out.println("Generated ID: "+IDGenerator.generateID());
    
}

}
