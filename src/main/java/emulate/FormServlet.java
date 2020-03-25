package emulate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static emulate.FormServlet.Helper.*;

@WebServlet(name="/FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {

    public interface Helper {
        String HEIGHT = "height";
        String WIDTH = "weight";

        //расчет индекса массы тела
        static Double calculateBMI(Double weight, Double height) {
            return weight / (height * height);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String height=request.getParameter(HEIGHT);
        String weight=request.getParameter(WIDTH);

        try {
            double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));
            //в отличие от задания аттрибутов через servletContext.setAttribute("emp",employee);
            //это аттрибут не для контекста сервлетов проекта, а только для данного request
            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            //за счет использования RequestDispatcher request вместе со своими переменными передается далее в bmi.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("bmi.jsp");
            dispatcher.forward(request, response);
            /*
            т.е. вот такая штука уже не сработает для передачи рассчитанного значения в bmi.jsp
             response.sendRedirect("bmi.jsp");
             */
        } catch (Exception e) {
            //а здесь просто открывается новый ресурс error.jsp с новым своим request-ом, а не унаследованным от bmi.jsp
            response.sendRedirect("error.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
