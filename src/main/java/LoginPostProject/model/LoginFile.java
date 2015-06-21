/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPostProject.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class LoginFile implements Login{
    private String filename;
    private List<String> passwords;
    private List<String> usernames;

    public LoginFile(String filename) {
        this.filename = filename;
        passwords = new ArrayList<>();
        usernames = new ArrayList<>();
        readFile();
    }
    
    @Override
    public boolean confirmLogin(String username, String password) {
        boolean isValid = false;
        for (int i = 0; i < usernames.size(); i++) {         
            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    
    private void readFile() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(getFilename()));
            String line = "";
            while ((line = fin.readLine()) != null) {
                String userPass[] = line.split(",");
                usernames.add(userPass[0]);
                passwords.add(userPass[1]);
            }
            fin.close();
        } catch (FileNotFoundException ex) {
            System.out.println("This failed to write details are " + ex);
        } catch (IOException ex) {
            System.out.println("This failed to write details are " + ex);
        }
    }
    
    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<String> passwords) {
        this.passwords = passwords;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
    
}
