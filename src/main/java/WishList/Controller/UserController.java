/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller;

import WishList.Storage.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class UserController {
    public boolean grantPermission(int userId, int friendId){
        return true;
    }
    
    public boolean revokePermission(int userId, int friendId){
        return true;
    }

    public boolean addUser(User user){
        return true;
    }
    
    public List<User> getFriends(int userId){
        return new ArrayList<User>();
    }
}
