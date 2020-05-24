package secure;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ServletSecurity(
        value=@HttpConstraint(rolesAllowed = {"auth"}),//роль прописана в настройках Tomcat
        httpMethodConstraints= {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"auth"}),//для каких ролей возможен GET
                @HttpMethodConstraint(value="POST")
        }
)

@WebServlet("/secured")
public class AuthentityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("Аутентификация пройдена");
        } catch (Exception e) {
            System.out.println("!!!!!!!!");
        }
    }
}
