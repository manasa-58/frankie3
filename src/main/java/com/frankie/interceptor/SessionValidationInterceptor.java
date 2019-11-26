package com.frankie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionValidationInterceptor extends HandlerInterceptorAdapter {
	
	final static Logger logger=Logger.getLogger( SessionValidationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("executing SessionValidationInterceptor :: preHandle method");
		HttpSession httpSession=request.getSession();
		
		String mailid=(String) httpSession.getAttribute("mailid");
		logger.debug("User name in session is :"  +mailid);
		if(mailid==null || mailid.isEmpty()){
			logger.debug("mailid is not available in session!!");
			logger.debug("user trying to skip the login page!!");
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("message","please login to acess this page!!");
			throw new ModelAndViewDefiningException(mv);
		}else{
			logger.debug("mailid is available in session!!");
			logger.debug("user already loged in!!");
			return true;
		}
	}

}
