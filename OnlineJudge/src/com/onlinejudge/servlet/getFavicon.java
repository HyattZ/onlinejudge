package com.onlinejudge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinejudge.tool.ReadFavicon;


public class getFavicon extends HttpServlet {
	/**
	 * 
	 *���ܣ���ȡͷ����ֽ���
	 * 
	 * */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*�������жϴ����������ĸ�ʽ�������ʽ����ֱ�ӷ��ؿ��ַ���*/
		String regex = "\\d{9}";
		String stuid = request.getParameter("stuid");
		if (stuid != null && stuid.matches(regex)){
			ReadFavicon rf = new ReadFavicon(request.getSession().getServletContext().getRealPath("")+"WEB-INF\\images\\"+stuid+".png");
			rf.outputFavicon(response.getOutputStream());
		}else{
			response.getWriter().write("");
		}
	}

	
}
