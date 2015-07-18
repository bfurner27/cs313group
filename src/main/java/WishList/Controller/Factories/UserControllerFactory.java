/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Factories;

import WishList.Controller.Implementations.ConcreteUserController;
import WishList.Controller.Interfaces.UserController;
import WishList.Controller.Implementations.MockUserController;

/**
 *
 * @author Schuyler
 */
public class UserControllerFactory {
    public UserController getUserController() {
        return new ConcreteUserController();
    }
}
