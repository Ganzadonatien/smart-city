<%-- 
    Document   : transport
    Created on : Jan 22, 2024, 9:58:41 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>transport</title>
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
            }
            h2{
                text-align: center;
                color: white;
                padding-top: 25px;
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
            <a  class="active" href="sign-up.jsp">Sign-up</a>
           <a href="index.html">Log-out</a>
           
            <a href="log-in.jsp" align="right">Admin</a>
        </div>
        <h1>Transport Agencies Available</h1>
        <table border="2" width="100%">
            <tr>
                <td width="25%">
                    <img src="ritco1.JPG">
                </td>
                <td width="25%"> 
                    <img src="ritco2.JPG">
                </td>
                <td width="25%">
                    <img src="ritco3.JPG">
                </td>
                <td width="25%">
                    <h2 >
                        Ritco.rw
                    </h2>
                    <P>
                        <a href="booking.jsp">Book</a>
                    </P>
                </td>
            </tr>
        </table>
    </body>
</html>
