/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.ControllerImplementations;

import WishList.Controller.Interfaces.WishListController;
import WishList.Storage.WishList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class MockWishListController implements WishListController {
    @Override
    public List<WishList> getWishLists(String userId){
        List<WishList> wishes = new ArrayList<WishList>();
        wishes.add(new WishList(40, "Fake list #1", "This is a fake list that is bigger than #2", "schuylerrs", true));
        wishes.add(new WishList(42, "Fake list #2", "This is a fake list that is smaller than #1", "schuylerrs", true));
        return wishes;
    }
           
    @Override
    public boolean addWishList(WishList wishList){
        return true;
    }
    
    @Override
    public boolean removeWishList(int wishListId){
        return true;
    }
}
