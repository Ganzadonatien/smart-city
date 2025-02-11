/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/bookingServlet"})
public class bookingServlet extends HttpServlet {
private user user;
private userDao userdao;
 
public void init(){
    this.user=new user();
    this.userdao=new userDao();
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bookingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Booking successful</h1>");
             out.println("<h1><a href='index.html'>Return Back!!!!!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String service=request.getParameter("service");
        String numberOfPeople=request.getParameter("customerNumber");
        String typeOfCustomer=request.getParameter("checkbox");
        String numberOfhours=request.getParameter("numberOfDays");
        HttpSession session=request.getSession();
        session.setAttribute("username", name);
        
        
        user.setName(name);
        user.setService(service);
        user.setNumberOfPeople(numberOfPeople);
        user.setTypeOfCustomer(typeOfCustomer);
        user.setNumberOfDays(numberOfhours);
        
        String username=(String)session.getAttribute("username");
        
 
        try{
        userdao.bookHotel(user);
        if(userdao.bookHotel(user)>0){
            response.sendRedirect("bookingServlet");
            
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
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
