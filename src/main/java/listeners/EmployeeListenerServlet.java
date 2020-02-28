package listeners;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//считывает из контекста объект Employee и распечатывает его параметры
@WebServlet("/lisna1")
public class EmployeeListenerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Employee employee = (Employee) getServletContext().getAttribute("emp");
        Employee employee2 = (Employee) getServletContext().getAttribute("emp2");
        out.println(employee.getName());
        out.println(employee2.getName());

    }
}
