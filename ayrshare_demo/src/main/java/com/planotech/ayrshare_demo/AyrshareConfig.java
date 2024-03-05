package com.planotech.ayrshare_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AyrshareConfig {

	@Bean
	public HttpHeaders HttpHeaders() {
		return new HttpHeaders();
	}

	@Bean
	@Lazy
	public HttpEntity<String> getHttpEntity(String jsonString, HttpHeaders headers) {
		return new HttpEntity<>(jsonString, headers);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
