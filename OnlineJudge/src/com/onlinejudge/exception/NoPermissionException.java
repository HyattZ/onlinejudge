package com.onlinejudge.exception;

/**
 * @author 赵笑天
 *
 * @time 2015年9月26日
 * 
 */
public class NoPermissionException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public NoPermissionException(String msg){
		super(msg);
	}
}
