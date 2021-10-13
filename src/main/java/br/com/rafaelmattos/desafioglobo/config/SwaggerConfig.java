package br.com.rafaelmattos.desafioglobo.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private final ResponseMessage m200 = simpleMessage(200, "Search Success.");
	private final ResponseMessage m201 = simpleMessage(201, "Created Successfully.");
	private final ResponseMessage m204 = simpleMessage(204, "Updated subscription.");
	private final ResponseMessage m404 = simpleMessage(404, "The subscription was not found.");
	private final ResponseMessage m500 = simpleMessage(500, "Unexpected error.");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m200, m404, m500))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m500))
				.globalResponseMessage(RequestMethod.PATCH, Arrays.asList(m204, m404, m500))
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("br.com.rafaelmattos.desafioglobo.controller"))
				.paths(PathSelectors.any())
				.build()
				.ignoredParameterTypes()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Desafio Globo", 
				"User subscription update API.", 
				"version 1.0.0", 
				"",
				new Contact("Rafael Mattos", 
				"https://www.linkedin.com/in/rafael-mattos-moreira-414948197", 
				"rafaelrj@live.com"),
				"Restricted use for Globo.", 
				"", 
				Collections.emptyList() 														
		);
	}
	
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}
}