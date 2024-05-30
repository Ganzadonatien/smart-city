
package database11;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class data {
    public static void main (String[] args)
            {
         

                data d= new data();
                d.createconnection();
            }
    void createconnection()
    {
    try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/universe","root" ,"1234" );
     Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM JAVA");
    while(rs.next())
    {
    String name = rs.getString("name");
    System.out.println(name);
    }
    
     System.out.println("Database connection is done");
}
    catch (ClassNotFoundException Ex){
        
}       catch (SQLException ex) {
            Logger.getLogger(data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

