<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %> 

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update here.</title>   
    
    <style>
        /* styles.css */

        body {
            background-color: white;
            color: black;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: blue;
        }

        #msg {
            color: green;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        .form-label {
            display: block;
            margin-bottom: 5px;
            color: blue;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid blue;
            border-radius: 4px;
        }

        .btn {
            padding: 10px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
            color: white;
            font-weight: bold;
        }

        .btn-info {
            background-color: blue;
        }

        .btn-warning {
            background-color: orange; 
        }

        .btn-info:hover {
            background-color: darkblue;
        }

        .btn-warning:hover {
            background-color: darkorange; 
        }
    </style>
</head>
<body>
    <center>
        <h1>Student Update</h1>   
        <div align="right" style="margin-right:100px" >
            <p><a href="index.jsp">Click Back</a></p>
        </div>

        <div class="rw">
            <div class="col-s-4">
                <form method="POST" action="UpdateServlet">
                    <%    
                    Connection con;
                    PreparedStatement pst;
                    ResultSet rs;

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/schooll","root","");
                   
                    String id = request.getParameter("id");

                    pst = con.prepareStatement("select * from records where id = ?");
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    while(rs.next()) {
                    %>
                    <input type="hidden" name="id" value="<%= rs.getString("id")%>">
                    <div alight="left">
                        <label class="form-label">Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" value="<%= rs.getString("stname")%>" name="sname" id="sname" required >
                    </div>

                    <div alight="left">
                        <label class="form-label">Course</label>
                        <input type="text" class="form-control" placeholder="Course" name="course" value="<%= rs.getString("course")%>" id="course" required >
                    </div>

                    <div alight="left">
                        <label class="form-label">Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" value="<%= rs.getString("fee")%>" required >
                    </div>

                    <% }  %>

                    </br>

                    <div alight="right">
                        <input type="submit" id="submit" value="Update" name="submit" class="btn btn-info">
                        <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">
                    </div>  
                </form>
            </div>          
        </div>
    </center>
</body>
</html>
