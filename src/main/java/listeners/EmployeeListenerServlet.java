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
@WebServlet("/lisna1")
//@WebServlet(
//        value = "/lisna1",
//        initParams = {
//                @WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
//                @WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster")
//
//        },
//        description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")

public class EmployeeListenerServlet extends HttpServlet {
//    private String email, phone;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        email = config.getInitParameter("email");
//        phone = config.getInitParameter("phone");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Employee employee = (Employee) getServletContext().getAttribute("emp");
        Employee employee2 = (Employee) getServletContext().getAttribute("emp2");
        out.println(employee.getName());
        out.println(employee2.getName());

//        out.write("<h2>Servlet 3 inner initialisationparameter annotation example: @WebInitParam</h2>");
//        out.write("<p><strong>E-mail: </strong>" + email + "</p>");
//        out.write("<p><strong>Phone: </strong>" + phone + "</p>");
    }
}
