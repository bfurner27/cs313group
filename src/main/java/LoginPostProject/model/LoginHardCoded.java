/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPostProject.model;

/**
 *
 * @author Benjamin
 */
public class LoginHardCoded implements Login{

    @Override
    public boolean confirmLogin(String username, String password) {
        boolean isValid = false;
        if (username.equals("admin")) {
            if (password.equals("password"))
            {
                isValid = true;
            }
        }
        return isValid;
    }
    
}
