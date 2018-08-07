package lti.hola.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lti.hola.bean.RegisterBean;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		if (referer.contains("login.jsp")) {
			// request coming from home for login authentication
			RegisterBean user = LoginController.authenticate(request);
			if (user != null) { // Login sucessfull
				response.sendRedirect("profile.jsp");
			} else {
				// login failed
				response.sendRedirect("login.jsp");
			}

		} else if (referer.contains("registerpage.jsp")) {
			// request coming for user registration
			if (RegisterController.registration(request))
				response.sendRedirect("login.jsp");
			else
				response.sendRedirect("registerpage.jsp");

		} else if (referer.contains("forgetpass.jsp")) {
			// request coming for validating user for password

			if (LoginController.forgetPassword(request))
				response.sendRedirect("changepass.jsp");// email & movie matched
			else
				response.sendRedirect("login.jsp");

		} else {
			// request coming for updating password
			if (LoginController.changePassword(request))
				response.sendRedirect("login.jsp");
			else
				response.sendRedirect("changepass.jsp");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		
		if(referer.contains("profile.jsp"))
		{
			RegisterBean user = LoginController.show(request);
		}
		// Delegating call to doGet method to perform common logic
		doGet(request, response); // method chaining
	}

}
