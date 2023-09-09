package com.example.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apis() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example")) 
				.paths(PathSelectors.any())
				.build().apiInfo(metaData());
		 
		//.basePackage("com.example")
	}

	private ApiInfo metaData() {
	
			String title="Product Module Apis";
			String descreption="Product Module Api's descrption";
			String version="3.1.2";
			String termsOfServiceUrl="http://dru.care/"; 
			Contact contact=new Contact("prasanna kotha.k","http://dru.care/","kothaprasanna2001@gmail.com");
			String licence="Apache Licence version 2.0";
			String licenceUrl="http://www.pache.org/licences/Licence-2.0";
			@SuppressWarnings("rawtypes")
			Collection<VendorExtension> vendorExtensions =new ArrayList<>();
			
			return new ApiInfo(title, descreption, version, termsOfServiceUrl, contact, licenceUrl, licence, vendorExtensions);

}
}


