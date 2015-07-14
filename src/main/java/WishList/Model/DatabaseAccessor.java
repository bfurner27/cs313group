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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        if (DB_URL == null) {
            String dbHost = System.getenv("$OPENSHIFT_MYSQL_DB_HOST");
            String dbPort = System.getenv("$OPENSHIFT_MYSQL_DB_PORT");
            
            if (dbHost == null) {
                DB_URL = "jdbc:mysql://localhost:3306/wishlist";
                USER = "root";
                PASS = "";
            }
            else {
                DB_URL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/java";
                USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            }
        }
    }
    
    public List<Item> getItems(int wishListId) {
        return new ArrayList<Item>();
    }
    
    public boolean addItem(Item item){
        boolean success = true;

        return success;
    }
    
    public boolean removeItem(int itemId){
        boolean success = true;
        
        return success;
    }
    
    public boolean removeItem(Item item){
        boolean success = true;
                
        return success;
    }
    
    public List<WishList> getWishLists(String owner){
        Connection conn = null;
        Statement stmt = null;
        List<WishList> result = new ArrayList<WishList>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM wishlist WHERE owner = \'" + owner + "\'";
            ResultSet rs = stmt.executeQuery(sql);
            
            //STEP 5: Extract data from result set
            while(rs.next()){
                result.add(new WishList(rs.getString("name"), rs.getString("description"), rs.getString("owner"), rs.getBoolean("is_public"), rs.getString("imageurl")));
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

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wishlist");
//        List<WishList> result = null;
//        try {            
//            EntityManager em = emf.createEntityManager();
//                    
//            ExpressionBuilder builder = new ExpressionBuilder();
//            ReadAllQuery databaseQuery = new ReadAllQuery(WishList.class, builder);
//            databaseQuery.setSelectionCriteria(builder.get("owner").equal(owner));
//
//            Query query = ((JpaEntityManager)em.getDelegate()).createQuery(databaseQuery);
//            result = query.getResultList(); 
//        } finally {
//            emf.close();
//        }
        
        return result;
    }
           
    public boolean addWishList(WishList wishList){
        boolean success = true;
        
        return success;
    }
    
    public boolean removeWishList(int wishListId){
        boolean success = true;
        
        return success;
    }
    
    public boolean removeWishList(WishList wishList){
        boolean success = true;

        return success;
    }
}
