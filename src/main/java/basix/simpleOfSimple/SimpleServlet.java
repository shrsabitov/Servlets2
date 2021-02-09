package basix.simpleOfSimple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf8");

        PrintWriter out = response.getWriter();
        String n = request.getParameter("name");
        String s = request.getParameter("surname");

        out.println("<b>Здравствуйте, " + n + " " + s + ".</b><br><br>");
        out.println("<b>Вывод информации в сервлет.</b><br><br>");

        for (int i = 0; i < 100; i++) {
            out.println("<font size=" + i + ">");
            out.println("Вывод информации в сервлет.<br>");
            out.println("</font>");

        }

        out.println("<b>Вывод формы в сервлете.</b><br><br>");
        out.println("<form action=SimpleServlet1>"
                + "<input type=text name=name value=\"Имя\"><br>"
                + "<input type=text name=surname value=\"Фамилия\">"
                + "<input type=submit name=s1 value=Ok>"
                + "<input type=hidden name=h1 value=\"hiddenValue\">");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
