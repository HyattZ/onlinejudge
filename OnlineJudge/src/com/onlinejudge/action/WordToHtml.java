package com.onlinejudge.action;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;

import com.onlinejudge.constant.Status;
import com.onlinejudge.tool.Word2Html;

/**
 * @author 赵笑天
 *
 * @time 2015年9月28日
 * 
 */
@Component
public class WordToHtml implements ServletRequestAware {
	private Word2Html word2Html;
	private HttpServletRequest request;
	private String result;

	public Word2Html getWord2Html() {
		return word2Html;
	}
	@Resource(name="word2Html")
	public void setWord2Html(Word2Html word2Html) {
		this.word2Html = word2Html;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String wordToHtml(){
		boolean status = false;
		
		try{
			String savePath = request.getSession().getServletContext().getRealPath("") +"WEB-INF\\answers\\";
			File directory = new File (savePath);
			String[] fileNames = directory.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".doc");
				}
			});
			String desPath = request.getSession().getServletContext().getRealPath("")+"WEB-INF\\answerHtmls";
			File des = new File(desPath);
			if (!des.exists()){
				des.mkdirs();
			}
			for (String fileName:fileNames){
				String htmlFileName = fileName.replace(".doc", ".html");
				word2Html.convert2Html(savePath+fileName,desPath+htmlFileName );
			}			
			status = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.accumulate("status", status);
		result = json.toString();
		return Status.SUCCESS;
		
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
