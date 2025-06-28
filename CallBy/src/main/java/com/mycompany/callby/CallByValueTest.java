
package com.mycompany.callby;


public class CallByValueTest {
    public static void main(String[] args) {
        
        CallByValue ob1 =new CallByValue();
        int x= 10;
        System.out.println("x before call :"+x);
        
        ob1.change(x);
        System.out.println("X after call :"+x);
    }
    
}
