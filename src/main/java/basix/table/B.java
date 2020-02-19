package basix.table;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/B")
public class B extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;

        int row = 0, col = 0;

        try {
            row = Integer.parseInt(request.getParameter("rows"));
            col = Integer.parseInt(request.getParameter("columns"));
        } catch (NumberFormatException e) {
            System.out.println("Задать числа в качестве строк и столбцов:");
        }
        try {
            out = response.getWriter();
            out.println("" +
                    "Table: строк " + row + " столбцов " + col + getServletInfo().toString() + "\n" +
                    "<font name=tahoma size=6 bgcolor=White>" +
                    "<table border=2 bgcolor=yellow>" +
                    "");
            for (int i = 0; i < row; i++) {
                out.println("<tr>");
                for (int j = 0; j < col; j++) {
                    out.println("" +
                            "<td>i*j=" + i * j + "</td>" +
                            "");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
