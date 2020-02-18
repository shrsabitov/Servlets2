package basix.generators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        out = response.getWriter();
        out.println("Таблица сгенерирована в классе FirstPageGenerator статическим методом <i>mainForm</i><br>"
                + "Запрос в адресной строке вида: http://localhost:8080/MIR/MyServlet?st=x задает число столбцов таблицы равным x.<br><br>");

        int state=1;
        try{
            state=Integer.parseInt(request.getParameter("st"));
        }
        catch(NumberFormatException e){
            System.out.println(e.equals(null));
        }

        FirstPageGenerator.mainForm(request, response, state);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
