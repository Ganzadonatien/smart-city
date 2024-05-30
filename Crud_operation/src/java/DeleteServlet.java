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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            Connection con = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooll", "root", "1234");
                pst = con.prepareStatement("DELETE FROM 'schooll'.'records' WHERE id = ?");
                pst.setString(1, id);
                pst.executeUpdate();

                // Redirect to index.jsp after successful deletion
                response.sendRedirect("index.jsp?delete=success");
            } catch (ClassNotFoundException | SQLException e) {
                // Handle exceptions appropriately, e.g., log or show an error page
                e.printStackTrace();
                response.sendRedirect("index.jsp?delete=error");
            } finally {
                // Close resources in a real-world application
                if (pst != null) pst.close();
                if (con != null) con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
