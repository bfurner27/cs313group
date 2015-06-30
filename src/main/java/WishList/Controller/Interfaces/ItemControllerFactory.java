/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Interfaces;

import WishList.Controller.MockControllers.MockItemController;

/**
 *
 * @author Schuyler
 */
public class ItemControllerFactory {
    public ItemController getItemController()
    {
        return new MockItemController();
    }
}
