/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Factories;

import WishList.Controller.Implementations.ConcreteItemController;
import WishList.Controller.Interfaces.ItemController;
import WishList.Controller.Implementations.MockItemController;

/**
 *
 * @author Schuyler
 */
public class ItemControllerFactory {
    public ItemController getItemController()
    {
        return new ConcreteItemController();
    }
}
