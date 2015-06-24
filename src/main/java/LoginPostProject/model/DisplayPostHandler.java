/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPostProject.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class DisplayPostHandler {
    private File path;
    
    public DisplayPostHandler(String filePath) {
        path = new File(filePath);
        if (!path.exists()) {
            try {
                path.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(DisplayPostHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
       
        try {
            BufferedReader fin = new BufferedReader(new FileReader(path));
            for (int i = 0; fin.ready(); i++) {
                String line = fin.readLine();
                String sections[] = line.split((","));
                posts.add(new Post(sections[0], sections[1], sections[2], sections[3]));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisplayPostHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisplayPostHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }
}
