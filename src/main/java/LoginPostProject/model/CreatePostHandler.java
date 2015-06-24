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
public class CreatePostHandler {
    File filename;
    public CreatePostHandler(String filename) {
        this.filename = new File(filename);
        
        if (!this.filename.exists()) {
            try {
                this.filename.createNewFile();
            } catch (IOException ex) {
                System.out.println("ERROR: failed to create the new file!");
            }
        }
    }
    
    public void writePost(Post thePost) {
        try {
            BufferedWriter fout = new BufferedWriter(new FileWriter(filename, true));
            String format = thePost.getUser() + "," + thePost.getTitle() + "," + thePost.getContent() + "," + thePost.getDate();
            fout.write(format);
            fout.newLine();
            fout.close();
        } catch (IOException ex) {
            System.out.println("ERROR: failed to write the file!");
        }
    }
    
}
