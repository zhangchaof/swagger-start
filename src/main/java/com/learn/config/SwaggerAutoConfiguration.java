package com.learn.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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

/**
 * @program: swagger-start:SwaggerAutoConfigure
 * @description: 注入配置文件类
 * @author: zcf
 * @create: 2019-11-27 19:48
 **/
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {
    public SwaggerAutoConfiguration() {
    }

    @Bean
    public Docket createRestApi(SwaggerProperties swaggerProperties) {
        return (new Docket(DocumentationType.SWAGGER_2)).enable(swaggerProperties.isEnable()).apiInfo(this.apiInfo(swaggerProperties)).select().apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage())).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return (new ApiInfoBuilder()).title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription()).termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl()).contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail())).version(swaggerProperties.getVersion()).license(swaggerProperties.getLicense()).licenseUrl(swaggerProperties.getLicenseUrl()).build();
    }
}
