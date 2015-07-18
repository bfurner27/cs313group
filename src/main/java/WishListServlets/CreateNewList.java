/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.FacebookController;
import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Factories.WishListControllerFactory;
import WishList.Storage.Person;
import WishList.Storage.WishList;
import facebook4j.Facebook;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "CreateNewList", urlPatterns = {"/CreateNewList"})
public class CreateNewList extends HttpServlet {
    private static final int NUM_URLS = 3;

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
        
        //get variables from the post
        String name = request.getParameter("listName");
        String description = request.getParameter("description");
        
        //gets the facebook id of the individual so that the list will be associated with
        //that individual.
        
        Facebook facebook = (Facebook)request.getSession().getAttribute("facebook");

         // get the oauth code from facebook so that we can make future requests to facebook
            // from our actual class
            String oauthCode = request.getParameter("code");
            
            
            FacebookController.getInstance().setFacebookObject(facebook, oauthCode);

            Person displayUser = FacebookController.getInstance().requestUserInfo();
        String owner = displayUser.getUserId();
        
        String pictureURL = request.getParameter("pictureURL");
        
        // finds if the value is true
        boolean isPublic = true;
        if (request.getParameter("permission").equals("false"))
        {
            isPublic = false;
        }
        
        //check if they provided a url or they left it blank
        if (pictureURL.equals("")) {
            pictureURL = randomURLGenerator();
        }
        
        // This will add the wishlist so that it inserts the list into the database
        WishListControllerFactory wLCF = new WishListControllerFactory();
        WishListController wlc = wLCF.getWishListController();
        wlc.addWishList(new WishList(name, description, owner, isPublic, pictureURL));
        
        response.sendRedirect("UserHomePage");
        
    }
    
    
    /**
     * This will return a url that can be put in place if the user did not provide a URL
     * @return the url
     */
    public String randomURLGenerator() {
        String rndURL = "";
        Random rnd = new Random();
        switch(rnd.nextInt(NUM_URLS))
        {
            case 0:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg";
                break;
            case 1:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/9/94/Abstract_blue_background7.jpg";
                break;
            case 2:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/c/c5/Background_green_leave_macro.jpg";
                break;
            default:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/2000px-Red_flag.svg.png";
                break;
        }
        
        return rndURL;
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
