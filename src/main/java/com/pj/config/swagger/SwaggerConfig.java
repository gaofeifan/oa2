package com.pj.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc  
@EnableSwagger2
public class SwaggerConfig {
	   @Bean  
	   public Docket customDocket(){  
	      return new Docket(DocumentationType.SWAGGER_2)
		          	.apiInfo(apiInfo()) 
		          	.select()
//		          	.apis(RequestHandlerSelectors.basePackage("com.pj.flow.controller"))
//		            .apis(RequestHandlerSelectors.basePackage("com.pj.auth.controller"))
//		            .apis(RequestHandlerSelectors.basePackage("com.pj.system.controller"))
		          	.apis(RequestHandlerSelectors.basePackage("com.pj"))
		          	.build();  
	  
	   }  
	   private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("OA后台 接口文档示例")// 设置文档的标题
					.description("OA后台接口地址请关注：http://")
					.contact("Created by Contact Email")
					.license("Apache 2.0")
					.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
					.version("1.1")// 设置文档的版本信息-> 1.1 Version information
					.build();
		}
}