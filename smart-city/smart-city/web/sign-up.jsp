<%-- 
    Document   : sign-up
    Created on : Dec 29, 2023, 11:37:30 AM
    Author     : Nyihanzamaso Pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign-up</title>
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
            <a href="log-in.jsp">Log-in</a>
            <a href="log-in.jsp" align="right">Admin</a>
        </div>
        <form action="userServlet" method="post">
            <h2>
                Create account
            </h2>
            <table>
                <tr>
                    <td>
                        Name:  
                    </td>
                    <td>
                        <input type="text" name="name" size="40" placeholder="enter your name">  
                    </td>
                </tr>
                <tr>
                    <td>
                        E-mail:  
                    </td>
                    <td>
                        <input type="text" name="email" size="40" placeholder="enter your email">  
                    </td>
                </tr>
                <tr>
                    <td>
                        Country:  
                    </td>
                    <td>
                        <input type="text" name="country" size="40" placeholder="enter your country">  
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone-number:  
                    </td>
                    <td>
                        <input type="text" name="tel" size="40" placeholder="enter your phone-number">  
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:  
                    </td>
                    <td>
                        <input type="radio" name="gender" value="male">Male
                        <input type="radio" name="gender" value="female">Female
                    </td>
                </tr>
                <tr>
                    <td>
                        User-name:  
                    </td>
                    <td>
                        <input type="text" name="username" size="40" placeholder="enter your username">  
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:  
                    </td>
                    <td>
                        <input type="password" name="password">  
                    </td>
                </tr>
                <tr>
                    <td>
                        Re-enter Password:  
                    </td>
                    <td>
                        <input type="password" name="password">  
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="log-in.jsp"><input type="submit" value="submit">  </a>
                    </td>
                </tr>

            </table>
        </form>
    </body>
</html>
