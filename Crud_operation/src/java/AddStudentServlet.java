import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("sname");
            String course = request.getParameter("course");
            String fee = request.getParameter("fee");

            Connection con = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooll", "root", "1234");
                pst = con.prepareStatement("INSERT INTO 'schooll'.'records'(name', 'course', 'fee') VALUES (?, ?, ?)");
                pst.setString(1, name);
                pst.setString(2, course);
                pst.setString(3, fee);
                pst.executeUpdate();

                // Set a request attribute to indicate success (you can use this in your JSP)
        

            } catch (ClassNotFoundException | SQLException e) {
                // Set a request attribute to indicate error (you can use this in your JSP)
       
                e.printStackTrace();
            } finally {
                // Close resources in a real-world application
                if (pst != null) pst.close();
                if (con != null) con.close();
            }

            // Redirect to index.jsp after processing the form (PRG pattern)
            response.sendRedirect("index.jsp?add=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
