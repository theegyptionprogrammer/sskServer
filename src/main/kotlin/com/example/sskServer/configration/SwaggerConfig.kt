package com.example.sskServer.configration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo {
        return ApiInfo(
                "Kiro REST API",
                "This is a REST API of kiro REST API, where you can get/add/remove/modify Kiro board and its task.",
                "v1",
                "Terms of service",
                Contact("ishak kerolos", "www.github.com/wkrzywiec", ""),
                "License of API", "API license URL", java.util.Collections.emptyList()
        )
    }
}
