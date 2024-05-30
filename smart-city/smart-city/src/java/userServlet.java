/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/userServlet"})
public class userServlet extends HttpServlet {

    private userDao userdao;

    @Override
    public void init() {
        userdao = new userDao();
        user user=new user();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
                
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String phone_number = request.getParameter("tel");
        String gender = request.getParameter("gender");
        String user_name = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("name",name);
        user user = new user();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        user.setPhone_number(phone_number);
        user.setGender(gender);
        user.setUser_name(user_name);
        user.setPassword(password);
        try {
            userdao.registerUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("uname",name);
        try{
        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("INSERT INTO `smart_city`.`user_account` (`name`, `email`, `country`, `phone_number`, `gender`, `user_name`, `password`) VALUES (?,?,?,?,?,?,?);");
            ResultSet rs=ps.executeQuery();
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getPhone_number());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getUser_name());
            ps.setString(7, user.getPassword());

        }catch(Exception e){
            e.printStackTrace();
        }
        
         processRequest(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("/log-in.jsp");
        rd.include(request, response);


        
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
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String phone_number = request.getParameter("tel");
        String gender = request.getParameter("gender");
        String user_name = request.getParameter("username");
        String password = request.getParameter("password");

        user user = new user();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        user.setPhone_number(phone_number);
        user.setGender(gender);
        user.setUser_name(user_name);
        user.setPassword(password);
        try {
            userdao.registerUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("uname",name);
        try{
        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("INSERT INTO `smart_city`.`user_account` (`name`, `email`, `country`, `phone_number`, `gender`, `user_name`, `password`) VALUES (?,?,?,?,?,?,?);");
            ResultSet rs=ps.executeQuery();
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getPhone_number());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getUser_name());
            ps.setString(7, user.getPassword());
            request.setAttribute("userResult", rs);
            request.getRequestDispatcher("userlist.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
        
         processRequest(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("/log-in.jsp");
        rd.include(request, response);


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
