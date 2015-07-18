/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Implementations;

import WishList.Controller.FacebookController;
import WishList.Controller.Interfaces.UserController;
import WishList.Storage.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class ConcreteUserController implements UserController {
    @Override
    public boolean grantPermission(int userId, int friendId){
        return true;
    }
    
    @Override
    public boolean revokePermission(int userId, int friendId){
        return true;
    }

    @Override
    public boolean addUser(Person user){
        return true;
    }
    
    @Override
    public List<Person> getFriends(int userId){
        return FacebookController.getInstance().requestUserInfo().getFriends();
    }
}
