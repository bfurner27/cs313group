/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Interfaces;

import WishList.Storage.Person;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public interface UserController {
    public boolean grantPermission(int userId, int friendId);
    public boolean revokePermission(int userId, int friendId);
    public boolean addUser(Person user);
    public List<Person> getFriends(int userId);
}
