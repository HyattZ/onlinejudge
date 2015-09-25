package com.onlinejudge.dto;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 赵笑天
 *
 * @time 2015年9月24日
 * 
 */
public class RegisterFormBeanTest {


	@Test
	public void testValidateEmail() {
		RegisterFormBean rfb = new RegisterFormBean();
		rfb.setEmail("m18463102201@163.com");
		System.out.println(rfb.validateEmail());
	}

	/**
	 * Test method for {@link com.onlinejudge.dto.RegisterFormBean#validateRealName()}.
	 */
	@Test
	public void testValidateRealName() {
		RegisterFormBean rfb = new RegisterFormBean();
		rfb.setRealname("赵笑天");
		System.out.println(rfb.validateRealName());
	}

	/**
	 * Test method for {@link com.onlinejudge.dto.RegisterFormBean#validatePassword()}.
	 */
	@Test
	public void testValidatePassword() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.onlinejudge.dto.RegisterFormBean#validateStuid()}.
	 */
	@Test
	public void testValidateStuid() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.onlinejudge.dto.RegisterFormBean#validateUserName()}.
	 */
	@Test
	public void testValidateUserName() {
		fail("Not yet implemented");
	}

}
