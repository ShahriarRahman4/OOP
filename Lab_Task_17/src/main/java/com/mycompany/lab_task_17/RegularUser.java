
package com.mycompany.lab_task_17;


public class RegularUser extends User implements Postable, Followable{
     private int postCount;
    private int followerCount;
    
    public RegularUser(String username, String profilePicture) {
        super(username, profilePicture);
        this.postCount = 0;
        this.followerCount = 0;
    }
    
    public void postContent(String content) {
        postCount++;
        System.out.println(username + " posted: " + content);
    }
    
    public void follow(User user) {
        followerCount++;
        System.out.println(username + " started following " + user.username);
    }
    
    public int getFollowerCount() {
        return followerCount;
    }
    
    public void showProfile() {
        System.out.println("Regular User: " + username);
        System.out.println("Profile Picture: " + profilePicture);
        System.out.println("Posts: " + postCount);
        System.out.println("Followers: " + followerCount);
    }
    
    
}
