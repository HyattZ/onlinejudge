package com.onlinejudge.constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class ThreadLocalSession {
	private static ThreadLocal<HttpSession> sessionLocal = new ThreadLocal<HttpSession>();
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	
	public static HttpSession getSessionLocal() {
		return sessionLocal.get();
	}
	
	public static void setSessionLocal(HttpSession httpSession) {
		sessionLocal.set(httpSession);
	}

	public static HttpServletRequest getRequestLocal() {
		return requestLocal.get();
	}

	public static void setRequestLocal(HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static HttpServletResponse getResponseLocal() {
		return responseLocal.get();
	}

	public static void setResponseLocal(HttpServletResponse response) {
		responseLocal.set(response);
	}
	
}
