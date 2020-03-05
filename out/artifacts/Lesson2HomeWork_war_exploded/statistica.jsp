<%--
  Created by IntelliJ IDEA.
  User: Vitalii_Sindiakov
  Date: 3/4/2020
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stat</title>
</head>
<body>
<% String getPhoneCount = (String) session.getAttribute("contact=phone"); %>
<% String getEmailCount = (String) session.getAttribute("contact=email"); %>
<% String getMailCount = (String) session.getAttribute("contact=mail"); %>
<h2>Votes: Phone =<%= getPhoneCount %></h2>
<h2>Votes: Email =<%= getEmailCount %></h2>
<h2>Votes: Mail  =<%= getMailCount %></h2>
</body>
</html>
