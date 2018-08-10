package lti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private int counter;

	@Override
	public void init() throws ServletException {
		counter = 1001;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setting response MIME type
		response.setContentType("text/html");

		// getting response stream to write HTML output
		PrintWriter out = response.getWriter();

		// writing HTML as output on response stream
		out.println("<body bgcolor=black text=tomato");
		out.println("<h1>Hello Beautiful World</h1><hr>");
		out.println("WElcome to Servlets");
		Date now = new Date();
		out.println("<h3> Visit Time: " + now + "</h3>");
		out.println("<h3> Visitor No: "+counter++ +"</h3>");
		
		//Getting servlet config object from container
		ServletConfig config = getServletConfig();
		String author = config.getInitParameter("Author");
		out.println("<h3> Author: " + author + "</h3>");
		out.println("<h3> ServletName: " + config.getServletName() + "</h3>");
	}

}
