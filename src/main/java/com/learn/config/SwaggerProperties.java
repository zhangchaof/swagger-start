package com.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: swagger-start:SwaggerProperties
 * @description: 解析swagger参数
 * @author: zcf
 * @create: 2019-11-27 19:42
 **/
@ConfigurationProperties(prefix = "spring.swagger.learn")
@Data
public class SwaggerProperties {
    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
    private String version;
    private boolean enable;
    private String basePackage;
}
