package fileupload;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author test
 */

@WebServlet("/A_SaveXML")
public class A_SaveXML extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	response.setContentType("application/octet-stream");
    	response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"file.xml\"");

        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<?xml version=\"1.0\" encoding=\"utf-8\"  standalone=\"no\"?>\n" +
"<rs>\n" +
"<post>\n" +
"<postid>16</postid>\n" +
"<text>�������� ������������ �������� � �������</text>\n" +
"<topic_id>3</topic_id>\n" +
"<user_id>234</user_id>\n" +
"<date>31-12-2012</date>\n" +
"</post>\n" +
"\n" +
"<post>\n" +
"<postid>1024</postid>\n" +
"<text>�������� � ������ ���� �������� �������������</text>\n" +
"<topic_id>3</topic_id>\n" +
"<user_id>4</user_id>\n" +
"<date>31-12-2012</date>\n" +
"</post>\n" +
"\n" +
"<post>\n" +
"<postid>5</postid>\n" +
"<text>�������� � ������ ��������� ��� ������</text>\n" +
"<topic_id>3</topic_id>\n" +
"<user_id>4</user_id>\n" +
"<date>30-12-2012</date>\n" +
"</post>\n" +
"<post>\n" +
"<postid>12</postid>\n" +
"<text>������ ��������������� �������� �������� � ������.</text>\n" +
"<topic_id>3</topic_id>\n" +
"<user_id>5403</user_id>\n" +
"<date>02-02-2013</date>\n" +
"</post>\n" +
"</rs>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
