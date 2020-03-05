package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/statistic")
public class StatisticsServlet extends HttpServlet {
    private volatile String result;
    private volatile int countPhone = 0;
    private volatile int countEmail = 0;
    private volatile int countMail = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        result = req.getQueryString();
        System.out.println(result);
        PrintWriter writer = resp.getWriter();
        if (result.equals("contact=phone")) {
            countPhone = countPhone + 1;
        } else if (result.equals("contact=email")) {
            countEmail = countEmail + 1;

        } else if (result.equals("contact=mail")) {
            countMail = countMail + 1;
        }
        try {
        resp.setContentType("text/html");
            writer.println("<h2>Votes: " + "Phone" + " and count =" + countPhone + "</h2>");
            writer.println("<h2>Votes: " + "Email" + " and count =" + countEmail + "</h2>");
            writer.println("<h2>Votes: " + "Mail" + " and count =" + countMail + "</h2>");
        } finally {
            writer.close();
        }
    }
}
