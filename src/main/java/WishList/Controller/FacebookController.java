/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishList.Controller;

import facebook4j.Facebook;
import WishList.Model.FacebookApiInterface;
import WishList.Storage.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class FacebookController {
    //singleton pattern
    private static final FacebookController instance = new FacebookController();
    private FacebookApiInterface facebookAPI;

    private FacebookController() {

    }
    
    public static FacebookController getInstance() {
        return instance;
    }
    
    public void setFacebookObject(Facebook facebook, String oathCode) {
        facebookAPI = new FacebookApiInterface(facebook, oathCode);
    }
    
    public User requestUserInfo() {
        User user = null;
        try {
            user = facebookAPI.requestUserInfo();
        } catch (Exception ex) {
            Logger.getLogger(FacebookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    
    public String requestName() {
        return facebookAPI.requestName();
    }
    

}
