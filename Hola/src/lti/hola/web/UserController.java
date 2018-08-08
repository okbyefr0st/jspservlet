package lti.hola.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.hola.bean.RegisterBean;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		//Getting Session from request - /If session id exist in request header
		//old session object returned otherwise fresh session created
		HttpSession session= request.getSession();
		
		if (referer.contains("login.jsp")) {
			// request coming from home for login authentication
			RegisterBean user = LoginController.authenticate(request);
			if (user != null) {
				// Login sucessfull- keeping logged in user's details in session
				session.setAttribute("User", user);
				
				response.sendRedirect("profile.jsp");
			} else {
				// login failed
				response.sendRedirect("login.jsp?invalid=yes");
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
				response.sendRedirect("changepass.jsp?invalid=yes");// email & movie matched
			else
				response.sendRedirect("login.jsp");

		} else if (referer.contains("changepass.jsp")) {
			// request coming for updating password
			if (LoginController.changePassword(request))
				response.sendRedirect("login.jsp");
			else
				response.sendRedirect("changepass.jsp");
		}else {
			//Requesting for Logout, Destroying session
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Delegating call to doGet method to perform common logic
		doGet(request, response); // method chaining
	}

}
