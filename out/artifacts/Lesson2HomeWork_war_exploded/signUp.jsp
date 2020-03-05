<%@ page import="ua.kiev.prog.SignUpServlet" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>SignUP</title>
</head>
<body>
<% String login = (String)session.getAttribute("user_login"); %>

<% if (login == null || "".equals(login)) { %>
<h1>Create user</h1>
<form action="/signup" method="POST">
  Name: <input type="text" name="login"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" />
</form>
<% } else { %>
<br>Click this link to <a href="/login?a=exit">logout</a>
<% } %>
</body>
</html>
