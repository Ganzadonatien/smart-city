<%-- 
    Document   : booking
    Created on : Jan 21, 2024, 9:42:54 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <style>
            .menu{
                background-color: #333;
                overflow: hidden;
            }
            .menu a{
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }
            .menu a:hover {
                background-color: #ddd;
                color: black;
            }
            .menu a.active{
                background-color: lightsteelblue;
                color: white;
            }
            table,tr,td{
                background-color: none;
                margin-left:auto;
                margin-right: auto;
                padding-bottom: 16px;
                border-style: none;
                color: white;
            }
            h2{
                text-align: center;
                color: white;
                padding-top: 100px;
            }
            body{
                background-image: url("./background.jpg");
                background-size: cover;
                background-repeat: no-repeat;
            }
            form {
                font-size: 25px;
                color: white;
            }


        </style>
    </head>
    <body>
        <div class="menu">
            <a href="index.html">Home</a>
            <a href="services.jsp">Services</a>
       
            <a href="index.html">Log-out</a>
            <a href="log-in.jsp" align="right">Admin</a>
        </div>
        <h2>Enter the details here </h2>
        <table>
            <form action="bookingServlet" method="post" >
                <tr><td> Name:</td>
                    <td><input type="text" name="name"></td></tr>
                <tr><td>Service:</td>
                    <td><input type="text" name="service"></td></tr>
                <tr><td>Number of people:</td>
                    <td><input type="text" name="customerNumber"></td></tr>

                <tr><td>Type of customer:</td>
                    <td><input type="checkbox"  name="checkbox" value="male">Male</td>
                    <td> <input type="checkbox" name="checkbox" value="female">Female</td>
                    <td><input type="checkbox" name="checkbox" value="married">Couple</td></tr>
                <tr><td> Number of Days:</td>
                    <td><input type="text" name="numberOfDays"></td></tr>
                <tr><td><input type="submit" value="book"></td><tr>
            </form>
        </table>
    </body>
</html>
