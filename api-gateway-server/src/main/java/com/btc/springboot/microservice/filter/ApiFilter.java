package com.btc.springboot.microservice.filter;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@Component
public class ApiFilter extends ZuulFilter {

	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public String filterType() {
		
		return "pre";
	}
	
	@Override
	public Object run() throws ZuulException {
		log.info("Request Intercepted");
		
//		if(LocalDateTime.now().isBefore(LocalDateTime.of(LocalDate.now(),LocalTime.of(21, 5)))){
//			log.info("Succes.. You are Welcome");
//			return null;
//		}
//		RequestContext context=RequestContext.getCurrentContext();
//		context.setSendZuulResponse(false);
//		context.setResponseStatusCode(HttpStatus.SC_NOT_ACCEPTABLE);
//		log.error("Sorry Store is Closed");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

}