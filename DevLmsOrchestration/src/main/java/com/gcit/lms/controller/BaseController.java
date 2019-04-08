package com.gcit.lms.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public abstract class BaseController {

	protected RestTemplate template;
	
	public BaseController(RestTemplateBuilder restTemplateBuilder) {
		this.template = restTemplateBuilder.build();
	}
	
	protected final String aport = "http://localhost:8060/lms/admin";
	protected final String bport = "http://localhost:8070/lms/borrower-service";
	protected final String lport = "http://localhost:8080/lms/librarian";
}
