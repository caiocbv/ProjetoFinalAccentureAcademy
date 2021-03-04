package com.projeto.accenture.config;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.accenture.dto.SessaoDTO;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket detalheApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.projeto.accenture"))
	            .paths(PathSelectors.ant("/**"))
	            .build()
	            .apiInfo(this.informacoesApi().build())
	            .ignoredParameterTypes(SessaoDTO.class)
	            .globalOperationParameters(Arrays.asList(
	                    new ParameterBuilder()
	                    .name("Authorization")
	                    .description("Autorização utilizadando Token Jwt")
	                    .modelRef(new ModelRef("string"))
	                    .parameterType("header")
	                    .required(false)
	                    .build()));
	}
	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("API - Projeto Final Gama Acadamy");
		apiInfoBuilder.description("Equipe - Behind The Lines");
		apiInfoBuilder.version("1.0");
 
		return apiInfoBuilder;
 
	}
}

