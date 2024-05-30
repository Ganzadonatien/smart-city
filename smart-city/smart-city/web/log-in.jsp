<%-- 
    Document   : log-in
    Created on : Dec 30, 2023, 9:08:23 AM
    Author     : Nyihanzamaso Pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>log-in</title>
        <style>
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
                padding-top: 60px;

            }
            h1{
                text-align: center;
                color: white;
                padding-top: 110px;

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
            .body{
                background-image: url("./background.jpg");
                background-size: cover;
                background-repeat: no-repeat;
            }
            a{
                font-size: 20px;
                text-decoration: none;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="menu">
            <a href="index.html">Home</a>
            <a href="services.jsp">Services</a>
            <a   href="sign-up.jsp">Sign-up</a>
            <a class="active" href="log-in.jsp" >Log-in</a>
            <a href="log-in.jsp">Admin</a>
        </div>
        <h1>

        </h1>
        <h2>
            Log in Here
        </h2>
        <form action="loginServlet" method="post">
            <table>
                <tr>
                    <td>
                        User-name:
                    </td>
                    <td>
                        <input type="text" name="name" size="40" placeholder="enter your username">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="password" name="password" size="40" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Log In">
                    </td>
                    <td>
                        <a href="sign-up.jsp">Do you have account? create account</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
