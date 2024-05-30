<%-- 
    Document   : services
    Created on : Jan 17, 2024, 8:56:26 PM
    Author     : Nyihanzamaso Pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services</title>
        <style>
            table{
                border: groove;
                background-image: url("./backgroung3.jpg");
            }
            a{
                text-decoration: none;
                font-size: 25px;
            }
            h1{
                text-align: center;
                color: whitesmoke;
                padding-top: 60px;
            }
            table,tr,td{
                
                padding-top:16px;
                border-style: none;
                font-family: Times New Roman ;
            }


            h3{
                text-align: left;
                color: whitesmoke;
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
                background-image: url("./");
                background-size: cover;
                background-repeat: no-repeat;
            }

        </style>
    </head>
    <body>
        <div class="menu">
            <a href="index.html">Home</a>
            <a  class="active" href="services.jsp">Services</a>
            <a   href="sign-up.jsp">Sign-up</a>
            <a  href="log-in.jsp" >Log-in</a>
            <a href="index.html">Log-out</a>
             <a href="log-in.jsp" align="right">Admin</a>
        </div>
        <h1>OUR SERVICES</h1>
        <table border="0" width="100%" height="100%">
            <tr>
                <td width="33.3%">
                    <a href="hotel.jsp"<h2>Hotel Booking</h2></a>
                </td>
                <td width="33.3%">
                    <a href="transport.jsp"><h2>Transport Booking</h2></a>
                </td>
                <td width="33.3%">
                    <a href="hospital.jsp"<h2>Hospital Booking</h2>
                </td>

            </tr>
            <tr>
                <td width="33.3%">

                    <h3>
                        Hotels available
                    </h3>
                </td>
                <td width="33.3%">
                    <h3>
                        Transport Agencies available
                    </h3>
                </td>
                <td width="33.3%">
                    <h3>
                        Hospitals available
                    </h3>
                </td>
                <td width="33.3%">
                    <h3>


            </tr>
            <tr >
                <td width="33.3%">


                    <ol>
                        <li>
                            Hotels in Kigali
                        </li>
                        <li>
                            Hotels near Lake Kivu
                            <ul>
                                <li>
                                    Hotels in Rubavu(Gisenyi)
                                </li>
                                <li>
                                    Hotels in Karongi
                                </li>
                                <li>
                                    Hotels in Rusizi 
                                </li>
                            </ul>
                        </li>
                        <li>
                            Hotels in Musanze(Ruhengeri) 
                        </li>
                        Hotels near Muhazi lake
                    </ol>
                </td>
                <td width="33.3%">

                    <ol>
                        <li>
                            Ritco 
                        </li>
                        <li>
                            Virunga Express
                        </li>
                        <li>
                            Volcano Express
                        </li>
                    </ol>
                </td>
                <td width="33.3%">

                    <ol>
                        <li>
                            King Faisal Hospital
                        </li>
                        <li>
                            La Croix du Sud Hospital
                        </li>
                        <li>
                            Ruli Hospital
                        </li>
                        <li>
                            CHUK
                        </li>
                        <li>
                            CHUB
                        </li>
                        <li>
                            Rwanda Military Hospital
                        </li>
                        <li>
                            UGHE
                        </li>
                    </ol>
                </td>

            </tr>
        </table>
    </body>
</html>
