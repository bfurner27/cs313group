/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scriptures.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scriptures.bll.Scripture;

/**
 *
 * @author Benjamin
 */
public class MysqlScriptureDao implements ScriptureDao {

    @Override
    public Scripture getScripture(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Scripture getScripture(String book, int chapter, int verse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addScripture(String book, int chapter, int verse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeScripture(Scripture scripture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateScripture(Scripture scripture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Scripture> getAllScriptures() {
        List<Scripture> scriptures = new ArrayList<Scripture>();
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String user = "adam";
            String password = "eve";
            
            //user = System.getenv("OPENSHIFT_MYSQL_DB_USER"); for open shift
            
            if (user == null || user.equals("")) {
                user = "adam";
            }
            
            String dbURL = "jdbc:mysql://localhost/scripture_demo";
            
            Connection conn = DriverManager.getConnection(dbURL, user, password);
            
            Statement statement = conn.createStatement();
            
            String sql = "SELECT id,book,chapter,verse FROM scripture";
            
            ResultSet results = statement.executeQuery(sql);
             
            while (results.next()) {
                int id = results.getInt("id");
                String book = results.getString("book");
                int chapter = results.getInt("chapter");
                int verse = results.getInt("verse");
                
                Scripture scripture = new Scripture(book, chapter, verse, id);
                scriptures.add(scripture);
            }
            
            results.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlScriptureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return scriptures;
    }
    
}
