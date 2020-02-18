package basix.generators;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstPageGenerator {

    public static void mainForm(HttpServletRequest request,
                                HttpServletResponse response, int state) {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println("mainForm:");
            out.println("<table border=3>");

            for (int i = 0; i < 10; i++) {
                out.println("<tr>");
                for (int j = 0; j < state; j++) {
                    out.println("<td>");
                    out.println("i*j=" + i * j);
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

    }

}

