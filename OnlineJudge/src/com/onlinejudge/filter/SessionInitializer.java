package com.onlinejudge.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinejudge.constant.ThreadLocalSession;
import com.onlinejudge.enums.IsLogin;

/**
 * Servlet Filter implementation class SessionInitializer
 */
public class SessionInitializer implements Filter {
	/**
	 * Default constructor.
	 */
	public SessionInitializer() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		if (servletRequest.getSession().getAttribute("isLogin") == null) {
			servletRequest.getSession().setAttribute("isLogin", false);
		}
		
		if(servletRequest.getSession().getAttribute("loginStatus") == null){
			servletRequest.getSession().setAttribute("loginStatus", IsLogin.NO);
		}
		
		ThreadLocalSession.setSessionLocal(servletRequest.getSession());
		ThreadLocalSession.setRequestLocal(servletRequest);
		ThreadLocalSession.setResponseLocal((HttpServletResponse)response);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
