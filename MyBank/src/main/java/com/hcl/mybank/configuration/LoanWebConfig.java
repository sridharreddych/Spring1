package com.hcl.mybank.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.hcl.mybank.dao.impl.UserLoginDAOImpl;
import com.hcl.mybank.model.validator.UserLoginValidator;
import com.hcl.mybank.service.impl.UserLoginServiceImpl;
import com.hcl.mybank.service.impl.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hcl.mybank")
public class LoanWebConfig {

	@Autowired
	private Environment environment;

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	

	@Bean
	public UserServiceImpl getUserService() {
		return new UserServiceImpl();
	}

	
	@Bean
	public UserLoginDAOImpl getUserLoginDAOImpl() {
		return new UserLoginDAOImpl(getDataSource());
	}
/*
	@Bean
	public UserLoginValidator getUserLoginValidator() {
		return new UserLoginValidator();
	}*/

	

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:dbconfig");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybank");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");

		return dataSource;
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
