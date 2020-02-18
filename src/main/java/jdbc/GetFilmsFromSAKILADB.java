package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/GetFilmsFromSAKILADB")
public class GetFilmsFromSAKILADB extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        out.println(""
                + "<form action=GetFilmsFromSAKILADB method=GET>"
                + "Вывести первые"
                +"<select name=select1>"
                +"<option>5</option>"
                +"<option>10</option>"
                +"<option>20</option>"
                +"<option>30</option>"
                +"<option>50</option>"
                +"<option>1000</option>"
                +"</select>"+" фильмов"
                + "<input type=submit name=s1 value=OK>"
                + "</form>"
                + "");



        try {

            int select1 = Integer.parseInt(request.getParameter("select1"));
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
                    PreparedStatement p = con.prepareStatement("SELECT title,description FROM film WHERE film_id<?;");
                    p.setInt(1, select1);
                    ResultSet r = p.executeQuery();
                    out.println("<table border=3 bgcolor=yellow>");
                    while (r.next()) {
                        out.println("<tr>");

                        out.println("<td>");
                        out.println(r.getString("title"));
                        out.println("</td>");

                        out.println("<td>");
                        out.println(r.getString("description"));
                        out.println("</td>");

                        out.println("</tr>");
                    }
                    out.println("<table>");

                    r.close();
                    p.close();
                    con.close();

                } catch (Exception e) {

                }

                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        } catch (NumberFormatException e) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
