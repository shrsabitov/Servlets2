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

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
        /*

        Мне нужно чтобы сервлет переправил пользователя на указанную страницу. Есть два пути это сделть.
req.getRequestDispatcher("/demo/new.jsp").forward(req, resp);
//или
       resp.sendRedirect("/demo/new.jsp");


В случае редеректа все работает, как задумано, одноко с getRequestDispatcher перехода не происходит. Пользователь остается на странице сервлета.
        И так, отличия.
Forward:
выполняется непосредственно сервлетом
браузер абсолютно не в курсе, что происходит, и его исходный URL не меняется
перезагрузка страницы в браузере инициирует запрос на оригинальный URL


Redirect:
состоит из двух шагов, в которых Ваше приложение говорит браузеру получить контент с другого URL, отличного от оригинального URL
перезагрузка страницы не инициирует запрос по оригинальному URL, а пойдет по URL из redirect
немного медленнее, т.к. приходится делать 2 запроса вместо одного
данные оригинального запроса (первого), будут недоступны второму запросу


Проще говоря, через forward вы можете вернуть контент с другого ресурса, другую jsp. При этом исходный URL не изменится.
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
