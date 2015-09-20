package com.onlinejudge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.onlinejudge.enums.Permission;

/**
 * @author 赵笑天
 *
 * @time 2015年9月20日
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissonCheck {
	Permission[] value();
}
