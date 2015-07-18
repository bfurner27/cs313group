/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.FacebookController;
import WishList.Controller.Interfaces.UserController;
import WishList.Controller.Factories.UserControllerFactory;
import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Factories.WishListControllerFactory;
import WishList.Storage.Person;
import WishList.Storage.WishList;
import facebook4j.Facebook;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeongyul kim
 */
@WebServlet(name = "ViewLists", urlPatterns = {"/ViewLists"})
public class ViewLists extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            String friendId = request.getParameter("friend_id");
            UserController userController = new UserControllerFactory().getUserController();
                    
                    
            WishListController wishListController = new WishListControllerFactory().getWishListController();
            List<WishList> items2 = wishListController.getWishLists(friendId);
            
            request.setAttribute("items2", items2);
                            
            List<Person> friends = userController.getFriends(3);
            request.setAttribute("user", displayUser);
            request.setAttribute("friends", friends);
            
            
            request.getRequestDispatcher("WishList/view_lists.jsp").forward(request, response);
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
