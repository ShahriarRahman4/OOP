
package com.mycompany.lab_task_17;


public class Influencer extends User implements Postable, Followable{
     private String niche;
    private int followerCount;
    private int postCount;
    
    public Influencer(String username, String profilePicture, String niche) {
        super(username, profilePicture);
        this.niche = niche;
        this.followerCount = 0; 
        this.postCount = 0;
    }
    
    public void postContent(String content) {
        postCount++;
        System.out.println(username + " posted to " + followerCount + " followers: " + content);
    }
    
    public void follow(User user) {
        System.out.println(username + " follows " + user.username + " (influencer follow)");
    }
    
    public int getFollowerCount() {
        return followerCount;
    }
    
    public void showProfile() {
        System.out.println("?Influencer: " + username);
        System.out.println("Niche: " + niche);
        System.out.println("Profile Picture: " + profilePicture);
        System.out.println("Followers: " + followerCount);
        System.out.println("Posts: " + postCount);
    }
    
}
