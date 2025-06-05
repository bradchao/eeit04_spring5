package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	public OpenAPI createOpenAPI() {
		OpenAPI api = new OpenAPI();
		api.components(new Components())
		.info(new Info().title("Brad Big Company")
				.version("v0.01")
				.description("全世界最厲害的 API")
				.contact(new Contact().name("Brad").email("brad@brad.tw")));
		
		
		
		return api;
	}
	
}
