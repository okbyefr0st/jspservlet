package lti.hola.web;

import javax.servlet.http.HttpServletRequest;

import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class RegisterController {

	
			public static boolean registration(HttpServletRequest request) {
				UserService service = new UserServiceImpl();

				// instantiating login bean to hold registration creds
				RegisterBean register = new RegisterBean();
				
				//Reading request parameters and storing in REGISTRATION bean object
						register.setName(request.getParameter("name"));
						register.setEmail(request.getParameter("email"));
						register.setPassword(request.getParameter("password"));
						register.setAge(Integer.parseInt(request.getParameter("age")));
						register.setGender(request.getParameter("gender"));
						register.setCity(request.getParameter("city"));
						register.setMovie(request.getParameter("movie"));
						register.setPhoto(request.getParameter("photo"));
						return service.persist(register);
			}
}
