/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.data;

import java.util.List;
import scriptures.bll.Scripture;

/**
 *
 * @author Benjamin
 */
public interface ScriptureDao {
    
    Scripture getScripture(int id);
    Scripture getScripture(String book, int chapter, int verse);
    
    boolean addScripture(String book, int chapter, int verse);
    boolean removeScripture(Scripture scripture);
    boolean updateScripture(Scripture scripture);
    
    List<Scripture> getAllScriptures();
}
