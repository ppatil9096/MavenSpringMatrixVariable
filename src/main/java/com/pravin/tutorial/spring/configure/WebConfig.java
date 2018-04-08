package com.pravin.tutorial.spring.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.pravin.tutorial.spring.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

    public InternalResourceViewResolver Resolver() {
	InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	internalResourceViewResolver.setViewClass(JstlView.class);
	internalResourceViewResolver.setPrefix("/WEB-INF/views/");
	internalResourceViewResolver.setSuffix(".jsp");
	return internalResourceViewResolver;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
	UrlPathHelper helper = new UrlPathHelper();
	// Enable matrix variable
	helper.setRemoveSemicolonContent(false);
	configurer.setUrlPathHelper(helper);
    }
}
