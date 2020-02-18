import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/basic/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //простейший пример, вывести 10 раз "Hello, World!" через response
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        //int number = Integer.parseInt(req.getParameter("number"));
        PrintWriter out = resp.getWriter();
        for (int i = 0; i < 10; i++) {
            out.println("Hello, world!");
        }
    }
}
