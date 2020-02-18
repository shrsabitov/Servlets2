package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/GetFilmsFromSAKILADB")
public class GetFilmsFromSAKILADB extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(""
                + "<form action=GetFilmsFromSAKILADB method=GET>"
                + "Вывести первые"
                + "<select name=select1>"
                + "<option>5</option>"
                + "<option>10</option>"
                + "<option>20</option>"
                + "<option>30</option>"
                + "<option>50</option>"
                + "<option>1000</option>"
                + "</select>" + " фильмов"
                + "<input type=submit name=s1 value=OK>"
                + "</form>"
                + "");


        int select1 = Integer.parseInt(request.getParameter("select1"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");

        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
