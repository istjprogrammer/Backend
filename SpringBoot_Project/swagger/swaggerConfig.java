package com.example.demo.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI openApi() {
        Info info = new Info()
                .title("이현재")
                .version("2호선")
                .description("주연통삼겹");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
