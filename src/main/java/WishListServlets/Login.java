/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import facebook4j.Facebook; 
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //to work with local host I need the following info in the app setting on facebook
        //http://localhost:8080/
        
        Facebook facebook = null;
        FacebookFactory ff;
        String propertiesPath = System.getenv("OPENSHIFT_DATA_DIR");
        
        if (propertiesPath != null) {
            propertiesPath = propertiesPath + "facebook4j.properties";
            
            //found code from http://www.avajava.com/tutorials/lessons/how-do-i-read-a-properties-file.html
            
            // read in the file
            File propertiesFile = new File(propertiesPath);
            FileInputStream inputStream = new FileInputStream(propertiesFile);
            
            // load the file into the properties object
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            
            // get the properties from the properties file
            String debugString = properties.getProperty("debug");
            boolean debug = false;
            if (debugString.equals("true")) {
                debug = true;
            }
            
            String jsonStoreEnabledString = properties.getProperty("jsonStoreEnabled");
            boolean jsonStoreEnabled = false;
            if (jsonStoreEnabledString.equals("true")) {
                jsonStoreEnabled = true;
            }
            
            String oAuthAppId = properties.getProperty("oauth.appId");
            String oAuthAppSecret = properties.getProperty("oauth.appSecret");
            String oAuthPermissions = properties.getProperty("oauth.permissions");
            
            //build a configuration builder
            // found code to help at http://facebook4j.org/en/configuration.html
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(debug);
            cb.setJSONStoreEnabled(jsonStoreEnabled);
            cb.setOAuthAppId(oAuthAppId);
            cb.setOAuthAppSecret(oAuthAppSecret);
            cb.setOAuthPermissions(oAuthPermissions);
            
            ff = new FacebookFactory(cb.build());
            
        } else {
            //found code from http://www.avajava.com/tutorials/lessons/how-do-i-read-a-properties-file.html
            
            // read in the file
            propertiesPath = "C:\\Users\\jeongyul kim\\Documents\\NetBeansProjects\\cs313group\\src\\main\\java\\facebook4j.properties";
            File propertiesFile = new File(propertiesPath);
            Properties properties;
            // load the file into the properties object
            try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
                // load the file into the properties object
                properties = new Properties();
                properties.load(inputStream);
                
                inputStream.close();
            }
            
            
            // get the properties from the properties file
            String debugString = properties.getProperty("debug");
            boolean debug = false;
            if (debugString.equals("true")) {
                debug = true;
            }
            
            
            
            String jsonStoreEnabledString = properties.getProperty("jsonStoreEnabled");
            boolean jsonStoreEnabled = false;
            if (jsonStoreEnabledString.equals("true")) {
                jsonStoreEnabled = true;
            }
            
            String oAuthAppId = properties.getProperty("oauth.appId");
            String oAuthAppSecret = properties.getProperty("oauth.appSecret");
            String oAuthPermissions = properties.getProperty("oauth.permissions");
            
            //build a configuration builder
            // found code to help at http://facebook4j.org/en/configuration.html
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(debug);
            cb.setJSONStoreEnabled(jsonStoreEnabled);
            cb.setOAuthAppId(oAuthAppId);
            cb.setOAuthAppSecret(oAuthAppSecret);
            cb.setOAuthPermissions(oAuthPermissions);
            
            
            
            ff = new FacebookFactory(cb.build());
        }
        
        // get the new facebook instance
        facebook = ff.getInstance();
        

        request.getSession().setAttribute("facebook", facebook);

        StringBuffer requestUrl = request.getRequestURL(); 
        int lastSlashIndex = requestUrl.lastIndexOf("/");

        String callBackUrl = requestUrl.substring(0, lastSlashIndex) + "/UserHomePage";


        
        String facebookUrl = facebook.getOAuthAuthorizationURL(callBackUrl);
        

        response.sendRedirect(facebookUrl); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
