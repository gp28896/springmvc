package com.neu.naam.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.neu.naam.pojo.User;

public class Interceptor extends  HandlerInterceptorAdapter {

	 private String signout;
	    
	   
	    
	    public String getsignout() {
		return signout;
	}

	public void setsignout(String signout) {
		this.signout = signout;
	}

		/**
	     * This implementation always returns <code>true</code>.
	     */
	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	        throws Exception {
	        
	        System.out.println("Inside User Interceptor");
	        HttpSession session = request.getSession();
	        if(session != null){
	            
	        
	        
	        Object o = session.getAttribute("user");
	        if(o != null){
	            
	        try{
	            User user = (User) o;
	            return true;
	        }
	        catch(Exception e){
	            System.out.println("Exception in Recruiterinterceptor");
	            e.printStackTrace();
	        }}else{
	            response.sendRedirect(signout);
	            return false;
	        }
	        
	        }
	        
	        response.sendRedirect(signout);
	        return false;
	    }

	    /**
	     * This implementation is empty.
	     */
	    @Override
	    public void postHandle(
	            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	            throws Exception {
	        super.postHandle(request, response, handler, modelAndView);
	    }    
}
