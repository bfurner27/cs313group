/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.ControllerImplementations;

import WishList.Controller.Interfaces.UserController;
import WishList.Storage.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class MockUserController implements UserController {
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
        List<Person> fakeFriends = new ArrayList<Person>();
        fakeFriends.add(new Person("Schuyler Summers", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xfp1/v/t1.0-1/p160x160/12200_10152651374589664_4626641301439505659_n.jpg?oh=4c53694a225c6f8104b0bd71ff70d6f9&oe=5620732D&__gda__=1445950647_89fdf377a87d889b051b75916e2ba321", "schuylerrs"));
        fakeFriends.add(new Person("Ben Furner", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xap1/v/t1.0-1/c170.50.621.621/s160x160/7895_4884113267996_1080315210_n.jpg?oh=1a469a94ad1fc8fa7aeda362b602b876&oe=5634CD9E&__gda__=1445861729_016e1e2a899cf391b0fb5203443b08a3", "benFur"));
        fakeFriends.add(new Person("John Doe", "http://www.pushon.co.uk/wp-content/uploads/notw_silhouette-1.jpg", "johnDoe"));
        fakeFriends.add(new Person("John Doe", "http://www.pushon.co.uk/wp-content/uploads/notw_silhouette-1.jpg", "johnDoe"));
        fakeFriends.add(new Person("John Doe", "http://www.pushon.co.uk/wp-content/uploads/notw_silhouette-1.jpg", "johnDoe"));
        fakeFriends.add(new Person("John Doe", "http://www.pushon.co.uk/wp-content/uploads/notw_silhouette-1.jpg", "johnDoe"));
        fakeFriends.add(new Person("John Doe", "http://www.pushon.co.uk/wp-content/uploads/notw_silhouette-1.jpg", "johnDoe"));                                    
        
        return fakeFriends;
    }
}
