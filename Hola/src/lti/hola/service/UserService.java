package lti.hola.service;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;


/**
 * Services to perform operations on various databases
 * 
 * @author Abhishek,Ragini
 * 
 * @version 1.0
 *
 */


public interface UserService {

	RegisterBean authenticate(LoginBean login);
	
	boolean validate(ForgetBean forget);
	
	boolean changePassword(LoginBean login);
	
	boolean persist(RegisterBean register);
	
	
}
