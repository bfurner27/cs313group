/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.Interfaces.ItemController;
import WishList.Controller.Interfaces.ItemControllerFactory;
import WishList.Storage.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "CreateNewItem", urlPatterns = {"/CreateNewItem"})
public class CreateNewItem extends HttpServlet {

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
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        // get the price and convert it to float form
        String sPrice = request.getParameter("price");
        float price = Float.parseFloat(sPrice);
        
        String pictureURL = request.getParameter("pictureURL");
        String itemURL = request.getParameter("salesLink");
        
        // get the list id and convert it to and int
        String sListId = request.getParameter("listId");
        int listId = Integer.parseInt(sListId);
        
        // insert the item into the database
        ItemControllerFactory icf = new ItemControllerFactory();
        ItemController ic = icf.getItemController();
        
        //add item to the list
        ic.addItem(new Item(pictureURL, itemURL, description, name, price, listId));
        String urlRedirect = "ViewItems?my_list_id=" + sListId; 
        
        response.sendRedirect(urlRedirect);
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
