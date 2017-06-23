package com.pj.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc  
@EnableSwagger2
public class SwaggerConfig {
	   @Bean  
	   public Docket customDocket(){  
	      return new Docket(DocumentationType.SWAGGER_2).select()
		            .apis(RequestHandlerSelectors.basePackage("com.pj.flow.controller"))
//		            .apis(RequestHandlerSelectors.basePackage("com.pj.auth.controller"))
//		            .apis(RequestHandlerSelectors.basePackage("com.pj.system.controller"))
		            .build();  
	  
	   }  
}