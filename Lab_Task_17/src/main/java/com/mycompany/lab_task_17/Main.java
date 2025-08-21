
package com.mycompany.lab_task_17;


public class Main {
     public static void main(String[] args) {
        RegularUser regular = new RegularUser("x", "x.jpg");
        BusinessAccount business = new BusinessAccount("y", "y.jpg", "y-name", "Technology");
        Influencer influencer = new Influencer("fashion", "fashion.jpg", "Fashion");
        
        
        regular.showProfile();
        regular.postContent("Hello!");
        regular.follow(influencer);
        regular.showProfile();
        System.out.println();
        
        business.showProfile();
        business.postContent("new product!");
        business.showProfile();
        System.out.println();
        
        influencer.showProfile();
        influencer.postContent("New fashion");
        influencer.follow(business);
        influencer.showProfile();
        System.out.println();
        
       
        }
    }
    

