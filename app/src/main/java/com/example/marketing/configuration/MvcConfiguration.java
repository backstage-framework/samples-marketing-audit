package com.example.marketing.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfiguration implements WebMvcConfigurer
{
	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("/**")
				.allowedOrigins("http://localhost", "http://localhost:4200")
				.allowedMethods("*")
				.allowCredentials(true);
	}
}
