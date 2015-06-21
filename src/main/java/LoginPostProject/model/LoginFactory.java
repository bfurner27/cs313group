/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPostProject.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String dataDirectory = System.getenv("OPENSHIFT_DATA_DIR");
            try {    
                System.out.println(dataDirectory + "usernamesAndPasswords.txt");
                File file = new File(dataDirectory + "usernamesAndPasswords.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter fout = new BufferedWriter(new FileWriter("usernamesAndPasswords.txt"));
                fout.write("admin,password\nsillyBen80,gogroup\n");
            } catch (IOException ex) {
                System.out.println("This failed to write the file. Details are: " + ex);
            }
            instance = new LoginFile(dataDirectory + "usernamesAndPasswords.txt");
        }
        
        return instance;
    }
    
    public Login getFileCheckLogin(String fileName) {
        Login instance = null;
            String dataDirectory = System.getenv("OPENSHIFT_DATA_DIR") + "usernamesAndPasswords.txt";
            try {    
                File file = new File(dataDirectory);
                if (!file.exists()) {
                    file.createNewFile();
                
                    BufferedWriter fout = new BufferedWriter(new FileWriter(dataDirectory));
                    fout.write("admin,password");
                }
            } catch (IOException ex) {
                System.out.println("This failed to write the file. Details are: " + ex);
            }
            instance = new LoginFile(dataDirectory);
        return instance;
    }
}
