package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SignUpServlet extends HttpServlet {
    public static Map<String,String> usersData = new HashMap();
    private String userName;
    private String userPassword;

    protected void addUserToBase (String name, String password){
        if ((name!=null&&name!="")&& (password!=null&&password!=""))
            usersData.put(name,password);
    }

    protected static String getPassword(String name){
        String pass = usersData.get(name);
        return pass;
    }
    protected boolean isUserPresentAtBase(String name){
        boolean present = false;
        Set set = usersData.keySet();
        for (Object k:set){
            if (k==name){
                System.out.println("User is present");
                present=true;
            }
        }
        return present;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userName = req.getParameter("login");
        userPassword = req.getParameter("password");
        if (isUserPresentAtBase(userName)==true){
            resp.sendRedirect("signUp.jsp");
            //тут должна быть генерация еррор меседжа, что такой пользователь уже есть
        }else  {
            addUserToBase(userName,userPassword);
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.sendRedirect("signUp.jsp");
    }
}
