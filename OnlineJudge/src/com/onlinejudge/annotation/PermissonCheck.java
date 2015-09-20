package com.onlinejudge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.onlinejudge.enums.Permission;

/**
 * @author ��Ц��
 *
 * @time 2015��9��20��
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissonCheck {
	Permission[] value();
}
