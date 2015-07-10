/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WishListServlets;

import WishList.Controller.Interfaces.WishListController;
import WishList.Controller.Interfaces.WishListControllerFactory;
import WishList.Storage.WishList;
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
        String name = request.getParameter("listName");
        String description = request.getParameter("description");
        String owner = request.getParameter("owner");
        String pictureURL = request.getParameter("pictureURL");
        boolean isPublic = true;
        if (request.getParameter("permission").equals("false"))
        {
            isPublic = false;
        }
        
        //check if they supplied a url with their list
        if (pictureURL.equals("")) {
            pictureURL = randomURLGenerator();
        }
        
        WishListControllerFactory wLCF = new WishListControllerFactory();
        WishListController wlc = wLCF.getWishListController();
        wlc.addWishList(new WishList(name, description, owner, isPublic, pictureURL));
        
        response.sendRedirect("userPage.jsp");
        
    }
    
    public String randomURLGenerator() {
        String rndURL = "";
        Random rnd = new Random();
        switch(rnd.nextInt(NUM_URLS))
        {
            case 0:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/2000px-Red_flag.svg.png";
                break;
            case 1:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/9/94/Abstract_blue_background7.jpg";
                break;
            case 2:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/c/c5/Background_green_leave_macro.jpg";
                break;
            default:
                rndURL = "https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg";
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
