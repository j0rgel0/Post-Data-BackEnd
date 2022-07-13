package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.postdata.jwt.config.JwtFilter;

@SpringBootApplication
public class PostdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostdataApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		//registrationBean.addUrlPatterns("/api/products/*");
		registrationBean.addUrlPatterns("/api/user/*");
		return registrationBean;
	}

}
