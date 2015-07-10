/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller;

import WishList.Controller.Interfaces.WishListController;
import WishList.Model.DatabaseAccessor;
import WishList.Storage.WishList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public class ConcreteWishListController implements WishListController {
    private DatabaseAccessor dba;

    public ConcreteWishListController() {
        this.dba = new DatabaseAccessor();
    }
    
    @Override
    public List<WishList> getWishLists(String userId){
        return dba.getWishLists(userId);
    }
           
    @Override
    public boolean addWishList(WishList wishList){
        return dba.addWishList(wishList);
    }
    
    @Override
    public boolean removeWishList(int wishListId){
        return dba.removeWishList(wishListId);
    }
}
