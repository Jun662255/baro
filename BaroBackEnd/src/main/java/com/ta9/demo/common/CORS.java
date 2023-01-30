package com.ta9.demo.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORS implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST")
				.maxAge(3000);

		// addMapping : CORS를 적용할 url의 패턴을 정의
		// allowedOrigins : 허용할 origin을 정의
		// allowedMethods - HTTP Method를 지정
		// maxAge - 원하는 시간만큼 request를 cashing 함
	}
}