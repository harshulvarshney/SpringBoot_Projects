package com.java.ecomm.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		//implement some business logic here to check
		//if this filter is needed or not and return true/false
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = 
		RequestContext.getCurrentContext().getRequest();
		
		logger.info("Request URL : " + request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
