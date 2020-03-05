<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Login</title>
    <style>
        .b1 {
            background: yellow;
            color: black;
            font-size: 10pt;
        }
    </style>
</head>
<body>
<% String login = (String) session.getAttribute("user_login"); %>

<% if (login == null || "".equals(login)) { %>
<form action="/login" method="POST">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" class="b1"/>
</form>
<% } else { %>
<h1>You are logged in as: <%= login %>
</h1>
<br>Click this link to <a href="/login?a=exit">logout</a>
<% } %>
</body>
</html>
