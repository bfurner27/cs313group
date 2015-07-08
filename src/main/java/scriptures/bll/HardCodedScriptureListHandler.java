/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.bll;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class HardCodedScriptureListHandler implements ScriptureListHandler{
    
    @Override
    public List<Scripture> getFavoriteScriptures() {
        List<Scripture> scriptures = new ArrayList<>(); 
        scriptures.add(new Scripture("Provers", 3, 5)); 
        scriptures.add(new Scripture("Doctrine &amp; Covenants", 112, 10)); 
        scriptures.add(new Scripture("John", 7, 17));
        
        return scriptures;
    }

    @Override
    public void addScripture(Scripture scripture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
