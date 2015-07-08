/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.bll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class FileScriptureHandler implements ScriptureListHandler {
    private String fileName;

    public FileScriptureHandler(String fileName) {
       this.fileName = fileName;
    }

    public String getFileName() {
       return fileName;
    }

    public void setFileName(String fileName) {
       this.fileName = fileName;
    }
    
    public void addScripture(Scripture scripture) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(), true));
            writer.write(scripture.toFileString() + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("This failed to write details are " + ex);
        }
    }

    
    @Override
    public List<Scripture> getFavoriteScriptures() {
        List<Scripture> favs = new ArrayList<>();
        try {
            BufferedReader fin = new BufferedReader(new FileReader(getFileName()));
            String scripture = "";
            while ((scripture = fin.readLine()) != null) {
                Scripture scrip = new Scripture();
                scrip.loadFromFileString(scripture);
                favs.add(scrip);
            }
                
        } catch (FileNotFoundException ex) {
            System.out.println("This failed to write details are " + ex);
        } catch (IOException ex) {
            System.out.println("This failed to write details are " + ex);
        }
        
        return favs;
    }
    
}
