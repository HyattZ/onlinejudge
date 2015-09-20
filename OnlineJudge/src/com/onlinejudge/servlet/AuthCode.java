package com.onlinejudge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinejudge.tool.AuthCodeFactory;

/**
 * Servlet implementation class AuthCode
 */
public class AuthCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthCode() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 
		 * 功能：生成验证码并且把验证码的值写到session里面
		 * 
		 * */
		
		HttpSession session = request.getSession();
		
		//这里三条代码保证浏览器不进行缓存
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0);
		
		AuthCodeFactory factory = new AuthCodeFactory();
		String authCode = factory.outputVerifyImage(130, 50, response.getOutputStream(), 5);
		
		session.setAttribute("authcode", authCode);
		
	}


}
