package com.luxoft.mapetrenko.restdemoservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    static final Contact DEFAULT_CONTACT;
    static final ApiInfo DEMO_API_INFO;
    static final Set<String> PRODUCES_AND_CONSUMES;

    static {
        DEFAULT_CONTACT = new Contact(
                "Mykhailo Petrenko",
                "",
                ""
        );
        DEMO_API_INFO = new ApiInfo(
                "Demo REST Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
        PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json"));
    }



    /**
     * Available Swagger Documentation:
     *  /swagger-ui.html
     *  /v2/api-docs
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEMO_API_INFO)
                .produces(PRODUCES_AND_CONSUMES)
                .consumes(PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
