

package com.mycompany.problem_1;


public class Problem_1 {
    public static void main(String[] args) {
        
        String str1 = "Hello";
        String str2= "Word";
        
        String concated = str1+" "+str2;
        
        int length = str1.length();
        
        String substring =str1.substring(3);
        
        String uppercase=str1.toUpperCase();
        String lowercase=str2.toLowerCase();
        
        boolean areEqual =str1.equals(str2);
        int comparison =str1.compareTo(str2);
        
        System.out.println("Concated : "+concated);
        System.out.println("Length : "+length);
        System.out.println("Substring :"+substring);
        System.out.println("String 1 Upper Case :"+uppercase); 
        System.out.println("String 2 Lower Case :"+lowercase);
        System.out.println("Are Equal :"+areEqual);
        System.out.println("Comparison : "+comparison);
          
        
        
    }
   
}
