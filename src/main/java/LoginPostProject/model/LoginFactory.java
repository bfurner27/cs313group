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
public class LoginFactory {
    public Login getLoginVersion(String version) {
        Login instance = null;
        if (version.equals("HardCoded")) {
            instance = new LoginHardCoded();
        } else if (version.equals("FileHardCoded")) {
            instance = new LoginFile("");//usernamesAndPasswords.txt");
        }
        
        return instance;
    }
    
    public Login getFileCheckLogin(String fileName) {
        Login instance = null;
        instance = new LoginFile(fileName);
        return instance;
    }
}
