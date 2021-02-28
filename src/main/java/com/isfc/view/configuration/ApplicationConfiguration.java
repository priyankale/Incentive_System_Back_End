package com.isfc.view.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is Application configuration class
 * 
 * @author Priyanka Jawade
 *
 */
@Configuration
@EnableSwagger2
public class ApplicationConfiguration extends WebMvcConfigurationSupport {

	/**
	 * @return returns an instance of ApiSelectorBuilder, which provides a way to
	 *         control the endpoints exposed by Swagger.
	 */
	@Bean
	public Docket version1() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.isfc.view.controller")).paths(regex(".*" + ".*")).build()
				.enable(true).groupName("IncentiveSystem").apiInfo(new ApiInfoBuilder().description("Incentive system")
						.title("INCENTIVE SYSTEM FOR CAR DEALERS").build());
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}