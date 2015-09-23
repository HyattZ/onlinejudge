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
	 *功能：获取头像的字节流
	 * 
	 * */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*这里先判断传进来参数的格式，如果格式不对直接返回空字符串*/
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
