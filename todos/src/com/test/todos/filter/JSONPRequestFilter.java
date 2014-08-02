package com.test.todos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JSONPRequestFilter implements Filter {

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			             FilterChain chain) throws IOException, ServletException {
		
		if (!(request instanceof HttpServletRequest)) {
			throw new ServletException("This filter can only process HttpServletRequest requests");
		}

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (isJSONPRequest(httpRequest)) {
			ServletOutputStream out = response.getOutputStream();

			out.print(getCallbackMethod(httpRequest) + "(");
			chain.doFilter(request, response);
			out.print(");");

			response.setContentType("text/javascript");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	private String getCallbackMethod(HttpServletRequest httpRequest) {
		return httpRequest.getParameter("callback");
	}

	private boolean isJSONPRequest(HttpServletRequest httpRequest) {
		String callbackMethod = getCallbackMethod(httpRequest);
		
		return (callbackMethod != null && callbackMethod.length() > 0);
	}
}
