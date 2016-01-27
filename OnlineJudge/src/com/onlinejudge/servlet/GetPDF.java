package com.onlinejudge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinejudge.tool.ReadPDF;

public class GetPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReadPDF readPDF = new ReadPDF();
		String problemid = request.getParameter("problemid");
		
		String fileDirectory = request.getSession().getServletContext().getRealPath("/")+"WEB-INF\\answers\\";
		
		if (!readPDF.readPDFByProblemid(fileDirectory, problemid, response.getOutputStream())){
			response.getOutputStream().write("null".getBytes("UTF-8"));
		}
		
	}
}
