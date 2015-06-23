/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Model;

import WishList.Storage.WishList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class DatabaseAccessor {
    public List<WishList> getWishLists(int userId){
        return new ArrayList<WishList>();
    }
           
    public boolean addWishList(WishList wishList){
        return true;
    }
    
    public boolean removeWishList(int wishListId){
        return true;
    }
}
