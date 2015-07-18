/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.Interfaces.ItemController;
import WishList.Controller.Factories.ItemControllerFactory;
import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Factories.WishListControllerFactory;
import WishList.Storage.Item;
import WishList.Storage.WishList;
import java.io.IOException;
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
@WebServlet(name = "LoadFromListServlet", urlPatterns = {"/LoadFromListServlet"})
public class LoadFromListServlet extends HttpServlet {

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

            
            String id = request.getParameter("id");
              ItemController itemController = new ItemControllerFactory().getItemController();
     
              int id2 = Integer.parseInt(id);
            List<Item> items;
        items = itemController.getItems(id2);
            
            request.setAttribute("items", items);
            
            WishListController wishListController = new WishListControllerFactory().getWishListController();
            List<WishList> items2 = wishListController.getWishLists(id);
            
            request.setAttribute("items2", items2);
            
            // format the request url that will be used if the user would like to share an list with
            // facebook
            StringBuffer requestURL = request.getRequestURL();
            String goToAddress = "ViewItems?list_id=" + id;
            
            // get the index of the last portion and replace it with the goToAddress
            int indexLastPortion = requestURL.indexOf("LoadFromListServlet");
            requestURL.delete(indexLastPortion, requestURL.length());
            requestURL = requestURL.append(goToAddress);
            
            request.setAttribute("listURL", requestURL.toString());
            
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
