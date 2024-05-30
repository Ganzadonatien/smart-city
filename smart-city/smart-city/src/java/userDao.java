
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author user
 */
public class userDao {

    public int registerUser(user user) {
        int result = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("INSERT INTO `smart_city`.`user_account` (`name`, `email`, `country`, `phone_number`, `gender`, `user_name`, `password`) VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getPhone_number());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getUser_name());
            ps.setString(7, user.getPassword());
            result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "user saved successfully");
            } else {
                JOptionPane.showMessageDialog(null, "registration failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean validate(String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM smart_city.user_account WHERE name=? AND password=?;");
            ps.setString(1, name);
            ps.setString(2, password);
            try {
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        public boolean validateAdmin(String name, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM smart_city.admin WHERE name=? AND password=?;");
            ps.setString(1, name);
            ps.setString(2, password);
            try {
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int bookHotel(user user) {

        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            PreparedStatement ps = con.prepareStatement("INSERT INTO `smart_city`.`bookings` (`name`, `service`, `numberOfPeople`, `typeOfCustomer`, `numberOfDays`) VALUES (?,?,?,?,?);");

            ps.setString(1, user.getName());
            ps.setString(2, user.getService());
            ps.setString(3, user.getNumberOfPeople());
            ps.setString(4, user.getTypeOfCustomer());
            ps.setString(5, user.getNumberOfDays());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public user getUser(String name) {
        user user = new user();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "SELECT * FROM 'smart_city'.'user_account' WHERE name=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                user.setName(rs.getString(1));
                user.setEmail(rs.getString(2));
                user.setCountry(rs.getString(3));
                user.setPhone_number(rs.getString(4));
                user.setGender(rs.getString(5));
                user.setUser_name(rs.getString(6));
                user.setPassword(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(user user) {
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "UPDATE 'samrt_city'.'user_account' SET name=?, email=?, country=?, phone_number=?, gender=? user_name=?, password=? WHERE name=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getPhone_number());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getUser_name());
            ps.setString(7, user.getPassword());
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static List<user> getAllUsers() {
        List<user> userlist = new ArrayList<user>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "SELECT * FROM smart_city.user_account;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user user = new user();
                user.setName(rs.getString(1));
                user.setEmail(rs.getString(2));
                user.setCountry(rs.getString(3));
                user.setPhone_number(rs.getString(4));
                user.setGender(rs.getString(5));
                user.setUser_name(rs.getString(6));
                user.setPassword(rs.getString(7));
                userlist.add(user);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userlist;
    }

    public int deleteUser(int id) {
        int success = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "delete from smart_city.user_account where id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            success = ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static List<user> getAllBookings() {
        List<user> userlist = new ArrayList<user>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "SELECT * FROM smart_city.bookings;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user user = new user();
                user.setName(rs.getString(1));
                user.setService(rs.getString(2));
                user.setNumberOfPeople(rs.getString(3));
                user.setTypeOfCustomer(rs.getString(4));
                user.setNumberOfDays(rs.getString(5));
                user.setApprove(rs.getString(6));
                userlist.add(user);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userlist;
    }
        public int deleteBooking(int id) {
        int success = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_city?useSSL=false", "root", "1234");
            String sql = "delete from smart_city.bookings where id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            success = ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
