package ua.kiev.prog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ua.kiev.prog.SignUpServlet.getPassword;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String userPassword = getPassword(login);

        if (userPassword!=null && userPassword.equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);

        }else if (LOGIN.equals(login) && PASS.equals(password))
        response.sendRedirect("account.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);
        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");
        response.sendRedirect("login.jsp");
    }
}
