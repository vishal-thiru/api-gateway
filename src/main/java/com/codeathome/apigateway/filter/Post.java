package com.codeathome.apigateway.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Post extends ZuulFilter {

	  @Override
	  public String filterType() {
	    return "post";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
	    HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
	    
	    log.info("PostFilter: " + String.format("response's content type is %s", response.getStatus()));
	    
	    return null;
	  }
}