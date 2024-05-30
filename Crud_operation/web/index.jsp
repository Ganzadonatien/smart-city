<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Registration CRUD Operation</title>

    <style>
        /* styles.css */

        body {
            background-color: white;
            color: black;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: blue;
        }

        .row {
            display: flex;
            justify-content: space-between;
            margin: 20px;
        }

        .col-sm-4 {
            width: 35%;
        }

        .col-sm-8 {
            width: 60%
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

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table th, .table td {
            border: 1px solid blue;
            padding: 8px;
            text-align: left;
        }

        .table th {
            background-color: blue;
            color: white;
        }

        .table a {
            color: blue;
            text-decoration: none;
        }

        .table a:hover {
            text-decoration: underline;
            color: darkblue;
        }

        .panel-body {
            margin-top: 20px;
        }
        
            .message {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Student Registration CRUD Operation</h1>
    
    
    <div class="row">
        <div class="col-sm-4">
            <form method="POST" action="AddStudentServlet">
                <div alight="left">
                    <label class="form-label">Student Name</label>
                    <input type="text" class="form-control" placeholder="Student Name" name="sname" id="sname" required >
                </div>

                <div alight="left">
                    <label class="form-label">Course</label>
                    <input type="text" class="form-control" placeholder="Course" name="course" id="course" required >
                </div>

                <div alight="left">
                    <label class="form-label">Fee</label>
                    <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" required >
                </div>
                </br>

                <div alight="right">
                    <input type="submit" id="submit" value="submit" name="submit" class="btn btn-info">
                    <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">
                </div>
            </form>
        </div>

        <div class="col-sm-8">
            


              
            <div class="panel-body">
                <table id="table" class="table" cellpadding="" border-collapse="2" width="100%">

<label>

    <!-- delete message -->
    <div id="deleteMessage" style="display: none; color: green;"><h3>Record deleted successfully!</h3></div>

    <!-- inserted message -->
    <div id="insertMessage" style="display: none; color: green;"><h3>Record inserted successfully!</h3></div>

    <!-- update message -->
    <div id="updateMessage" style="display: none; color: green;"><h3>Record Updated successfully!</h3></div>

    <script>
        window.onload = function () {
            var deleteResult = '<%= request.getParameter("delete") %>';
            var insertResult = '<%= request.getParameter("add") %>';
            var updateResult = '<%= request.getParameter("Update") %>';

            if (deleteResult === 'success') {
                document.getElementById('deleteMessage').style.display = 'block';
                setTimeout(function() {
                    document.getElementById('deleteMessage').style.display = 'none';
                    window.history.replaceState({}, document.title, window.location.pathname);
                }, 2500); 
            }

            if (insertResult === 'success') {
                document.getElementById('insertMessage').style.display = 'block';
                setTimeout(function() {
                    document.getElementById('insertMessage').style.display = 'none';
                    window.history.replaceState({}, document.title, window.location.pathname);
                }, 2500); 
            }

            if (updateResult === 'success') {
                document.getElementById('updateMessage').style.display = 'block';
                setTimeout(function() {
                    document.getElementById('updateMessage').style.display = 'none';
                    window.history.replaceState({}, document.title, window.location.pathname);
                }, 2500); 
            }
        };
    </script>

</label>


                    <thead>
                        <tr>
                            <th>Student Name</th>
                            <th>Course</th>
                            <th>Fee</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Connection con = null;
                            Statement st = null;
                            ResultSet rs = null;

                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/schooll", "root", "");
                                st = con.createStatement();
                                String query = "select * from records";
                                rs = st.executeQuery(query);

                                while (rs.next()) {
                        %>
                                    <tr>
                                        <td><%= rs.getString("stname") %></td>
                                        <td><%= rs.getString("course") %></td>
                                        <td><%= rs.getString("fee") %></td>
                                        <td><a href="Update.jsp?id=<%= rs.getString("id") %>">Edit</a></td>
                                        <td>
                                            <a href="DeleteServlet?id=<%= rs.getString("id") %>"
                                               onclick="return confirm('Are you sure you want to delete?')">Delete</a>
                                        </td>
                                    </tr>
                        <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                // Close resources in a real-world application
                                if (rs != null) rs.close();
                                if (st != null) st.close();
                                if (con != null) con.close();
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
