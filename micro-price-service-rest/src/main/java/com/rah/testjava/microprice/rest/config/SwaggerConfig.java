package com.rah.testjava.microprice.rest.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		String apiPackage = "com.rah.testjava.microprice.service.api";
		return GroupedOpenApi.builder().group("").packagesToScan(apiPackage).pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		License license = new License();
		license.name("Apache 2.0");
		license.url("http://springdoc.org");

		Info info = new Info();
		info.title("Price API");
		info.description("Spring Price sample application");
		info.version("1.0.0");
		info.license(license);

		return new OpenAPI().info(info);
	}
}
