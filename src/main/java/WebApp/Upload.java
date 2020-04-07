package WebApp;

import DBApp.FileEntity;
import DBApp.TransactionController;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/upload")
@MultipartConfig()
public class Upload extends HttpServlet {
    FileJob fileJob = new FileJob();
    private TransactionController transactionController = new TransactionController();
    List<Part> fileParts;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        transactionController.toDataBase();
        resp.sendRedirect("result.jsp");
    }

    public List<Part> getList() {
        return fileParts;
    }
    }