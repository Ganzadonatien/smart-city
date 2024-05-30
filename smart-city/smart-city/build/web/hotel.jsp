<%-- 
    Document   : hotel
    Created on : Jan 21, 2024, 7:34:02 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hotel</title>
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
            <a  href="sign-up.jsp">Sign-up</a>
            <a href="index.html">Log-out</a>
            <a href="log-in.jsp" align="right">Admin</a>
        </div>
        <h1>HOTELS AVAILABLE</h1>
        <h2>Hotels in Kigali</h2>
        <table border="0" width="100%">
            <tr>
                <td rowspan="2" colspan="2" class="td">
                    <img src="mariot1.JPG" width="100%" height="100%">
                </td>
                <td class="td">
                    <img src="mariot2.JPG" width="100%" height="100%">
                </td>
                <td class="td">
                    <h3>Kigali Mariot Hotel</h3>
                    <p>
                        Price: $112 per night</br>
                        Price: $100 per day
                    </p>
                    <a href="booking.jsp">Book</a>
                </td>
            </tr>
            <tr>
                <td class="td">
                    <img src="mariot3.JPG" width="100%" height="100%">
                </td>
                <td class="td">
                    <img src="mariot4.JPG" width="100%" height="100%">
                </td>

            </tr>
        </table><br><br>
        <table border="2" width="100%">
            <tr>
                <td rowspan="2" colspan="2">
                    <img src="serena1.JPG" width="100%" height="100%">
                </td>
                <td>
                    <img src="serena2.JPG" width="100%" height="100%">
                </td>
                <td>
                    <h3>Kigali Serena Hotel</h3>
                    <p>
                        Price: $112 per night</br>
                        Price: $100 per day
                    </p>
                    <a href="bookingServlet.jsp">Book</a>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="serena3.JPG" width="100%" height="100%">
                </td>
                <td>
                    <img src="serena4.JPG" width="100%" height="100%">
                </td>

            </tr>
        </table>
    </body>
</html>
