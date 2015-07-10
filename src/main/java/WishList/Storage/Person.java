/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Storage;

import java.util.List;

/**
 *
 * @author Schuyler
 */
public class Person implements Displayable {
    private String userId;
    private String name;
    private String photoURL;
    private List<Friend> friends;

    public Person(String userId, String name, String photoURL, List<Friend> friends) {
        this.userId = userId;
        this.name = name;
        this.photoURL = photoURL;
        this.friends = friends;
    }
    
    

    public Person(String name, String photoURL, String userId) {
        this.name = name;
        this.photoURL = photoURL;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
    
        public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
    
    
    @Override
    public String getImageUrl() {
        return photoURL;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String getDescription() {
        return ""; // Cant thing of what to put here
    }

    @Override
    public String getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
