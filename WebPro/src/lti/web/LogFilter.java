package lti.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Response;

public class LogFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here to intercept request
		System.out.println("IP Addr: " + request.getRemoteAddr());
		System.out.println("Time :" + new Date());
		
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
		PrintWriter out = response.getWriter();
		out.println("<hr><p align=center>&copy; Copyright 2020 LTI</p>");
	
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		}

}
