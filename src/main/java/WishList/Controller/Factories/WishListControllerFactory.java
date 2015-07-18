/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Factories;

import WishList.Controller.Implementations.ConcreteWishListController;
import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Implementations.MockWishListController;

/**
 *
 * @author Schuyler
 */
public class WishListControllerFactory {
    public WishListController getWishListController() {
        return new ConcreteWishListController();
    }
}
