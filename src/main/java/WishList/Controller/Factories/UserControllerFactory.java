/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WishList.Controller.Factories;

import WishList.Controller.ControllerImplementations.ConcreteUserController;
import WishList.Controller.Interfaces.UserController;
import WishList.Controller.ControllerImplementations.MockUserController;

/**
 *
 * @author Schuyler
 */
public class UserControllerFactory {
    public UserController getUserController() {
        return new ConcreteUserController();
    }
}
