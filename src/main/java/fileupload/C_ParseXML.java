package fileupload;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Наиля
 */
@WebServlet("/C_ParseXML")
public class C_ParseXML extends HttpServlet {

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// *************************************************

		InputStream fileStream = FileUploading2.upload(request);//��������� � ��������� xml ����� �� ������

		ForumTableDataParser ftdp = SaxParsing.parseit(fileStream);//������� xml �����

		// *************************************************

		Iterator<TableInfo> it2 = ftdp.getParsedData().iterator();

		while (it2.hasNext()) {
			TableInfo t = it2.next();
			out.println(""+
					"����������� ���� � " + t.getPostId() + ":<br><br>"+
					"����: " + t.getPostDate() + "<br>"+
					"�����: "+ t.getPostText() + "<br>" + 
					"����: " + t.getTopicId()+ "<br><br><hr>");
		}

	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
