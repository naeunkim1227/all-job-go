package com.web.alljobgo.train.beans;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConnectionConfig {

	@Bean
	public RestTemplate CustomRestTemplate() {
		HttpComponentsClientHttpRequestFactory httpClientFactory = new HttpComponentsClientHttpRequestFactory();
		httpClientFactory.setConnectionRequestTimeout(2000);
		httpClientFactory.setReadTimeout(5000);
		
		HttpClient httpClient = HttpClientBuilder.create()
				.setMaxConnTotal(200)
				.setMaxConnPerRoute(20)
				.build();
		httpClientFactory.setHttpClient(httpClient);

		return new RestTemplate(httpClientFactory);
	}
}
