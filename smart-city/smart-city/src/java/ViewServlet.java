

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='sign-up.jsp'>Add User</a><br><a href='ViewServlet2'>Bookings</a><br><a href='index.html'>Home</a><br>");
		out.println("<h1>Users list</h1>");
		
		List<user> list=userDao.getAllUsers();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Phone_number</th><th>Gender</th><th>Username</th><th>Delete</th></tr>");
		for(user user:list){
			out.print("<tr><td>"+user.getName()+"</td><td>"+user.getEmail()+"</td><td>"+user.getCountry()+"</td><td>"+user.getPhone_number()+"</td><td>"+user.getGender()+"</td><td>"+user.getUser_name()+"</td><td>"+user.getPassword()+"</td><td><a href='DeleteServlet?id="+user.getName()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
         
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='sign-up.jsp'>Add User</a> <a href=''>Bookings</a>");
		out.println("<h1>Users list</h1>");
		
		List<user> list=userDao.getAllUsers();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Phone_number</th><th>Gender</th><th>Username</th><th>Edit</th><th>Delete</th></tr>");
		for(user user:list){
			out.print("<tr><td>"+user.getName()+"</td><td>"+user.getEmail()+"</td><td>"+user.getCountry()+"</td><td>"+user.getPhone_number()+"</td><td>"+user.getGender()+"</td><td>"+user.getUser_name()+"</td><td>"+user.getPassword()+"</td><td><a href='EditServlet?id="+user.getName()+"'>edit</a></td><td><a href='DeleteServlet?id="+user.getName()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
    
}
