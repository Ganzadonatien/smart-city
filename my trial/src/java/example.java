import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class example {

    public static void main(String[] args) throws SQLException {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/universe";
        String user = "root";
        String password = "1234";


        // JDBC variables for opening, closing, and managing connection
        Connection connection = null;

        try {
            // Step 1: Register JDBC Driver
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, user, password);

            // Step 3: Do something with the connection (e.g., execute SQL queries)

            // Step 4: Close the connection
            PreparedStatement stmt=connection.prepareStatement("insert into emp values(?,?)");  
stmt.setInt(1,101);//1 specifies the first parameter in the query  
stmt.setString(2,"Ratan");  
  
int i=stmt.executeUpdate();  
System.out.println(i+" records inserted");  
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        finally {
            // Finally block to close resources if needed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }
}
