package net.cominfo.digiagent.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) {

		String className = handler.getClass().getName();// packageName.ClassName
		if (true) {
			return false;
		}
		return true;
	}

}
