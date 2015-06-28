/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Model;

import WishList.Storage.User;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Picture;
import facebook4j.auth.AccessToken;
import static java.lang.System.out;
import java.net.URL;
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
    
    
    public User requestUserInfo() throws Exception {
        User user = null;
        
        try {
            facebook.getOAuthAccessToken();
            String userId = facebook.getId();
            facebook4j.User userInfo = facebook.getUser(userId);
            String photoURL = facebook.getPictureURL().toString();
            out.println(photoURL);
            
            
            user = new User(facebook.getName(), photoURL, userId);
        } catch (FacebookException ex) {
            Logger.getLogger(FacebookApiInterface.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("did not parse user");
        }
       
        
        return user;
    }
}
