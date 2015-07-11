/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.FacebookController;
import WishList.Controller.Interfaces.ItemController;
import WishList.Controller.Interfaces.ItemControllerFactory;
import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Interfaces.WishListControllerFactory;
import WishList.Storage.Item;
import WishList.Storage.Person;
import WishList.Storage.WishList;
import facebook4j.Facebook;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "UserHomePage", urlPatterns = {"/UserHomePage"})
public class UserHomePage extends HttpServlet {

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
            //get the facebook object that we have created
            Facebook facebook = (Facebook)request.getSession().getAttribute("facebook");
            
            // get the oauth code from facebook so that we can make future requests to facebook
            // from our actual class
            String oauthCode = request.getParameter("code");
            
            
            FacebookController.getInstance().setFacebookObject(facebook, oauthCode);

            Person displayUser = FacebookController.getInstance().requestUserInfo();
            
            //response.getWriter().write(displayUser.getFriends().get(0).getName());
            
            request.getSession().setAttribute("user", displayUser);
            
                ItemController itemController = new ItemControllerFactory().getItemController();
     
 
            List<Item> items = itemController.getItems(1);
            


            request.setAttribute("items", items);
            
            WishListController wishListController = new WishListControllerFactory().getWishListController();
            List<WishList> items2 = wishListController.getWishLists("test");
            
            request.setAttribute("items2", items2);
            
            request.getRequestDispatcher("WishList/index_logged.jsp").forward(request, response);
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
