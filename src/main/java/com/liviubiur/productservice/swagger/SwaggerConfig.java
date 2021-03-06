package com.liviubiur.productservice.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

  @Bean
  public Docket petApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.liviubiur.productservice.product.rest"))
            .paths(PathSelectors.any())
            .build().apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {

    return new ApiInfo(
            "Product Service API",
            "This is a Spring Boot RESTful service",
            "V1",
            "Terms of service",
            new Contact("Mario Rossi", "https://www.liviubiur.com", "liviu@liviubiur.com"),
            "CC2020",
            "https://license-url.com",
            Collections.emptyList()
    );
  }
}
