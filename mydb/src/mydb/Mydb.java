/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mydb;
import java.sql.*;
/**
 *
 * @author user
 */
public class Mydb {


    
    public static void main(String[] args) {
       Connection conn=null;
PreparedStatement ps=null;
       
       try{
           String URL="jdbc:mysql://localhost:3306/myemployee";
           String User="root";
           String password="1234";
           String name="pascal";
           String email="pascal23@gmail.com";
           String address="musanze";
           conn=DriverManager.getConnection(URL,User,password);
           if(conn==null){
               System.out.println("connection failed");
           }
           else{
               System.out.println("connection established");
               
           ps=conn.prepareStatement("INSERT INTO `myemployee`.`employee` (`name`, `email`, `address`) VALUES (?,?,?);");
           ps.setString(1, name);
           ps.setString(2, email);
           ps.setString(3, address);
           ps.executeUpdate();
           System.out.println("record added");
           }

       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
}
