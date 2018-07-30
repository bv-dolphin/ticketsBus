package com.javabrazzers.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket swaggerDolphinApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Название нашего апи-api-1.0")
                .select()
                .apis(p -> {
                    if (p.produces() != null) {
                        for (MediaType mt : p.produces()) {
                            if (mt.toString().equals("application/dolphin.app-v1.0+json")) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .build()
                .produces(Collections.singleton("application/dolphin.app-v1.0+json"))
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Bus API").description("Documentation XXXXXX API v1.0").build());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("XXXXXXXX REST API")
                .description("\"XXXXXX REST API for the XXXXXX \"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"))
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
