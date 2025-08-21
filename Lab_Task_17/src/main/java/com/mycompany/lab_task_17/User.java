
package com.mycompany.lab_task_17;


public abstract class User {
     protected String username;
    protected String profilePicture;
    
    public User(String username, String profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }
    
    public abstract void showProfile();
    
}
