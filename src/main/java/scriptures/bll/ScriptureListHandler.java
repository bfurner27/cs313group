/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.bll;

import java.util.List;

/**
 *
 * @author Benjamin
 */
public interface ScriptureListHandler {
    public List<Scripture> getFavoriteScriptures();
    public void addScripture(Scripture scripture);
}
