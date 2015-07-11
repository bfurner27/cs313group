/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Interfaces;

import WishList.Controller.ConcreteUserController;
import WishList.Controller.MockControllers.MockUserController;

/**
 *
 * @author Schuyler
 */
public class UserControllerFactory {
    public UserController getUserController() {
        return new ConcreteUserController();
    }
}
