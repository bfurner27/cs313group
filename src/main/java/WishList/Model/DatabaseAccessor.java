/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Forcing a build
 */

package WishList.Model;

import WishList.Storage.Item;
import WishList.Storage.WishList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * More information can be found here: https://wiki.eclipse.org/EclipseLink/Examples/JPA
 * @author Schuyler
 */
public class DatabaseAccessor {
    // JDBC driver name and database URL
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static String DB_URL = null;

    //  Database credentials
    static String USER;
    static String PASS;
    
    public DatabaseAccessor() {
        String dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST");

        if (dbHost == null) {
            DB_URL = "jdbc:mysql://localhost:3306/wishlist";
            USER = "root";
            PASS = "";
        }
        else {
            DB_URL = "jdbc:mysql://" + dbHost + ":" 
                + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/"
                + "javagroup";

            USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        }
    }
    
    public Item getItem(int id) {
                Connection conn = null;
        PreparedStatement  stmt = null;
        Item result = new Item();
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "SELECT * FROM item WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            
            //STEP 5: Extract data from result set
            result = new Item(rs.getString("picture_url"), rs.getString("url"), rs.getString("description"), rs.getString("name"), rs.getFloat("price"), rs.getInt("id"), rs.getInt("list_id"), rs.getDate("date_added"), rs.getInt("priority"), rs.getBoolean("is_claimed"));
 
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
        
        return result;
    }
    
    public List<Item> getItems(int wishListId) {
        Connection conn = null;
        PreparedStatement  stmt = null;
        List<Item> result = new ArrayList<Item>();
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "SELECT * FROM item WHERE list_id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, Integer.toString(wishListId));
            ResultSet rs = stmt.executeQuery();
            
            //STEP 5: Extract data from result set
            while(rs.next()){
                result.add(new Item(rs.getString("picture_url"), rs.getString("url"), rs.getString("description"), rs.getString("name"), rs.getFloat("price"), rs.getInt("id"), rs.getInt("list_id"), rs.getDate("date_added"), rs.getInt("priority"), rs.getBoolean("is_claimed")));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
        
        return result;
    }
    
    public boolean addItem(Item item){
        boolean success = true;
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "INSERT INTO item(list_id, description, price, url, picture_url, date_added, priority, is_claimed, name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, item.getListId());
            stmt.setString(2, item.getDescription());
            stmt.setFloat(3, item.getFloatPrice());
            stmt.setString(4, item.getUrl());
            stmt.setString(5, item.getImageUrl());
            stmt.setString(6, item.getDateSQL());
            stmt.setInt(7, item.getPriority());
            stmt.setBoolean(8, item.isClaimed());
            stmt.setString(9, item.getName());

            System.out.println(stmt.toString());
            stmt.execute();
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            success = false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            success = false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
               success = false;
            }//end finally try
         }//end try
        return success;
    }
    
    public boolean removeItem(int itemId){
        boolean success = true;
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "DELETE FROM item WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, itemId);

            System.out.println(stmt.toString());
            stmt.execute();
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            success = false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            success = false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
               success = false;
            }//end finally try
         }//end try
        return success;
    }
    
    public boolean removeItem(Item item){                
        return removeItem(item.getId());
    }
    
    public boolean updateItem(Item item) {
        boolean success = true;
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "UPDATE item SET list_id = ?, description = ?, price = ?, url = ?, picture_url = ?, date_added = ?, priority = ?, is_claimed = ?, name = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, item.getListId());
            stmt.setString(2, item.getDescription());
            stmt.setFloat(3, item.getFloatPrice());
            stmt.setString(4, item.getUrl());
            stmt.setString(5, item.getImageUrl());
            stmt.setString(6, item.getDateSQL());
            stmt.setInt(7, item.getPriority());
            stmt.setBoolean(8, item.isClaimed());
            stmt.setString(9, item.getName());
            
            stmt.setInt(10, item.getId());
            
            System.out.println(stmt.toString());
            stmt.execute();
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }catch(SQLException se){
            Logger.getLogger(DatabaseAccessor.class.getName()).log(Level.SEVERE, null, se);
            success = false;
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccessor.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
               success = false;
            }//end finally try
         }//end try
        return success;
    }
    
    public List<WishList> getWishLists(String owner){
        Connection conn = null;
        PreparedStatement  stmt = null;
        List<WishList> result = new ArrayList<WishList>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "SELECT * FROM wishlist WHERE owner = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, owner);
            ResultSet rs = stmt.executeQuery();
            
            //STEP 5: Extract data from result set
            while(rs.next()){
                result.add(new WishList(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("owner"), rs.getBoolean("is_public"), rs.getString("imageurl")));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
        
        return result;
    }
           
    public boolean addWishList(WishList wishList){
        boolean success = true;
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "INSERT INTO wishlist(description, imageurl, is_public, name, owner) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, wishList.getDescription());
            stmt.setString(2, wishList.getImageUrl());
            stmt.setBoolean(3, wishList.isIs_public());
            stmt.setString(4, wishList.getName());
            stmt.setString(5, wishList.getOwner());

            System.out.println(stmt.toString());
            stmt.execute();
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            success = false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            success = false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
               success = false;
            }//end finally try
         }//end try
        return success;
    }
    
    public boolean removeWishList(int wishListId){
        boolean success = true;
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        //Empty the list first
        List<Item> listItems = getItems(wishListId);
        for (Item item : listItems) {
            removeItem(item.getId());
        }
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "DELETE FROM wishlist WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, wishListId);

            System.out.println(stmt.toString());
            stmt.execute();
            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            success = false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            success = false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
               success = false;
            }//end finally try
         }//end try
        return success;
    }
    
    public boolean removeWishList(WishList wishList){
        return removeWishList(wishList.getId());
    }
}
