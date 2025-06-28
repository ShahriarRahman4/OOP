
package com.mycompany.callby;


public class CallByReferenceTest {
    public static void main(String[] args) {
        
        CallByReference r1 = new CallByReference();
        
        r1.name="Shifat";
        System.out.println("before calling :"+r1.name);
        
        r1.change(r1);
        System.out.println("After calling :"+r1.name);
        
    }
    
}
