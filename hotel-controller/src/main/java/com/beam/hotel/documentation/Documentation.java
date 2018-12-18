package com.beam.hotel.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Documentation {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Beam Hotel-Application-API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Beam Hotel","http://www.Beam-Hotel.com","info@Beam-Hotel.com");
        return new ApiInfoBuilder()
                .title("Beam Hotel API")
                .description("Beam Hotel application API Description")
                .license("license")
                .version("1.0")
                .contact(contact)
                .licenseUrl("licenseURl")
                .build();
    }
}
