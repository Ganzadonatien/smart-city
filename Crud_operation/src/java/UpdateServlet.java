
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
/**
 *
 * @author MONCHEL
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        String id = request.getParameter("id");
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        
        
        Connection con;
        PreparedStatement pst;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooll", "root", "1234");
        pst = con.prepareStatement("UPDATE 'school'.'records' SET name = ?, course = ?, fee = ? where id = ?");
        pst.setString(1, name);
        pst.setString(2, course);
        pst.setString(3, fee);
       
        pst.executeUpdate();

        // Redirect back to Update.jsp with a success message
        response.sendRedirect("index.jsp?Update=success");
    } catch (ClassNotFoundException | SQLException e) {
        // Handle exceptions appropriately, e.g., log or show an error page
        e.printStackTrace();
            response.sendRedirect("error.jsp"); 
    }
}}
