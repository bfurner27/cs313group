/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.bll;

/**
 *
 * @author Benjamin
 */
public class ScriptureListFactory {
    public ScriptureListHandler getScriptureDataHandler(String type) {
        ScriptureListHandler instance = null;
        if (type.equals("HardCoded"))
            instance = new HardCodedScriptureListHandler(); 
        else if (type.equals("File")) {
            instance = new FileScriptureHandler("list.txt");
        }
        else if (type.equals("db")) {
            instance = new DatabaseScriptureListHandler();
        }
        return instance;
    }
}
