
package com.mycompany.lab_task_17;


public class BusinessAccount extends User implements Postable {
     private String businessName;
    private String category;
    private int postCount;
    
    public BusinessAccount(String username, String profilePicture, String businessName, String category) {
        super(username, profilePicture);
        this.businessName = businessName;
        this.category = category;
        this.postCount = 0;
    }
    
    public void postContent(String content) {
        postCount++;
        System.out.println(businessName + " posted promotion: " + content);
    }
    
    public void showProfile() {
        System.out.println("Business Account: " + username);
        System.out.println("Business Name: " + businessName);
        System.out.println("Category: " + category);
        System.out.println("Profile Picture: " + profilePicture);
        System.out.println("Promotional Posts: " + postCount);
    }
    
}
