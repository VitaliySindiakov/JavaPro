<%--
  Created by IntelliJ IDEA.
  User: Vitalii_Sindiakov
  Date: 3/3/2020
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HomePage</title>
    <style>
      .b1 {
        background: cadetblue;
        color: greenyellow;
        font-size: 25pt;
      }
      .b2{
        background: lightblue;
        color: black;
        font-size: 25pt;
      }
    </style>
  </head>
  <body>
  <form action="/login" method="GET">
    <input type="submit" class="b2" value="Login"/>
  </form>
  <form action="/signup" method="GET">
    <input type="submit" class="b1" value="Create User" />
  </form>
  </body>
</html>
