
package com.mycompany.practice_constructor;


public class Test5_Ractangle {
    public static void main(String[] args)
    {
        Rectangle ob1 = new Rectangle(12,14);
        Rectangle ob2 = new Rectangle(ob1);
        
        ob1.Display();
        ob2.Display();
    }
    
}
