package com.osprey.studio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Конфигурация Swagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Внимание: application/tickets-bus.app-v1.0+json  используется в @RequestMapping()
     */
    @Bean
    public Docket swaggerTicketsBusApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Tickets Bus api-1.0")
                .select()
                .apis(p -> {
                    if (p.produces() != null) {
                        for (MediaType mt : p.produces()) {
                            if (mt.toString().equals("application/tickets-bus.app-v1.0+json")) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .build()
                .produces(Collections.singleton("application/tickets-bus.app-v1.0+json"))
                .apiInfo(metaData());
    }

    /**
     * Дополнительная информация для отображении на форме Swagger;
     */
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Osprey Studio")
                .description("Community for learning programming ")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Justin", "https://www.youtube.com/channel/UCDeXVSzWf2jmIFnOpgWIKIA", "ospreystudio2018@gmail.com"))
                .build();
    }


}
