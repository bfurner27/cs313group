/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.bll;

import java.util.List;
import scriptures.data.MysqlScriptureDao;

/**
 *
 * @author Benjamin
 */
public class DatabaseScriptureListHandler implements ScriptureListHandler {

    @Override
    public List<Scripture> getFavoriteScriptures() {
        MysqlScriptureDao dao = new MysqlScriptureDao();
        
        return dao.getAllScriptures();
    }
    public void addScripture(Scripture scripture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
