
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao userdao = new userDao();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        userdao.deleteUser(id);

        response.sendRedirect("ViewServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao userdao = new userDao();
        user user = new user();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        userdao.deleteUser(id);
        response.sendRedirect("ViewServlet");
    }
}
