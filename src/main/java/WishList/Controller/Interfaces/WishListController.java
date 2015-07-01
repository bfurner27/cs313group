/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Interfaces;

import WishList.Storage.WishList;
import java.util.List;

/**
 *
 * @author Schuyler
 */
public interface WishListController {
    public List<WishList> getWishLists(int userId);
    public boolean addWishList(WishList wishList);
    public boolean removeWishList(int wishListId);
}
