/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Model;

import WishList.Storage.Friend;
import WishList.Storage.Person;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Picture;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Schuyler
 */
public class FacebookApiInterface  extends HttpServlet {
    Facebook facebook;
    String oauthCode;
    
    public FacebookApiInterface(Facebook facebook, String oauthCode) {
        this.facebook = facebook;
        try {
            AccessToken oAuthAccessToken = this.facebook.getOAuthAccessToken(oauthCode);
                this.facebook.setOAuthAccessToken(oAuthAccessToken);
            } catch (FacebookException e) {
                e.printStackTrace();
            }
        
    }
    
    public String requestName() {
        try {
            this.facebook.getOAuthAccessToken();
            return facebook.getName();
        } catch (FacebookException | IllegalStateException ex) {
            Logger.getLogger(FacebookApiInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "This failed to work";
    }
    
    
    public Person requestUserInfo() throws Exception {
        Person user = null;
        
        try {
            facebook.getOAuthAccessToken();
            String userId = facebook.getId();
            facebook4j.User userInfo = facebook.getUser(userId);
            String photoURL = facebook.getPictureURL().toString();
            
            ResponseList<facebook4j.Friend> friends = facebook.getFriends(userId);
            System.out.println("My list of friends: " + friends.getCount());
            
            String friendId = "";
            String friendName = "";
            String friendPictureURL = "";
            
            List<WishList.Storage.Friend> myFriends = new ArrayList<>();
          
            for (facebook4j.Friend friend : friends)
            {
                out.println("This is the list: " + friend.getName());
                friendId = friend.getId();
                friendName = friend.getName();
                friendPictureURL = facebook.getPictureURL(friendId).toString();
                myFriends.add(new WishList.Storage.Friend(friendId, friendName, friendPictureURL));
            }
            
            
            user = new Person(userId, facebook.getName(), photoURL, myFriends);
        } catch (FacebookException ex) {
            Logger.getLogger(FacebookApiInterface.class.getName()).log(Level.SEVERE, null, ex);
            //throw new Exception("did not parse user");
            System.out.println(ex.toString());
        }
       
        
        return user;
    }
    
    /**
     * This will post the wishlist url to facebook along with a message that the 
     * user specifies.
     * @param wishListURL - this is the the url to the wishlist
     * @param message - this is the message that the user wants to post along with the wishlist.
     */
    public void postWishlistURL(String wishListURL, String message) {
        try {
            facebook.postLink(new URL(wishListURL), message);
            
        } catch (FacebookException | MalformedURLException ex) {
            Logger.getLogger(FacebookApiInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
