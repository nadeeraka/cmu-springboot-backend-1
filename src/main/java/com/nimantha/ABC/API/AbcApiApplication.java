package com.nimantha.ABC.API;

import com.nimantha.ABC.API.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcApiApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter() {
//		FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		source.registerCorsConfiguration("/**", config);
//		registrationBean.setFilter(new CorsFilter(source));
//		registrationBean.setOrder(0);
//		return registrationBean;
//	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
