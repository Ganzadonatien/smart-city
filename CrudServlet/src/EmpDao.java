import java.util.*;
import java.sql.*;

public class EmpDao {

        private static final String INSERT_USERS_SQL = "INSERT INTO `demo`.`users` (`name`, `password`, `email`, `country`) VALUES (?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,password,email,country from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,password=?, email= ?, country =? where id = ?;";
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
		}catch (ClassNotFoundException | SQLException e)
                {e.printStackTrace();}
		return con;
	}
	public static int save(Emp e){
		int status = 0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(UPDATE_USERS_SQL);
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_USER_BY_ID );
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
