package team.sun.integration.config;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * swagger-ui的配置
 */
/*@Configuration
@EnableSwagger2*/
public class SwaggerConfig {
    private static final String ALI_PACKAGE = "team.sun.integration.modules";
    private boolean enableSwagger = true;

    private static List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringBoot1.0 API")
                .apiInfo(apiInfo())
                //控制是否生效
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ALI_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("安全工器具项目整合")//这是标题
                .description("")//这是描述
                .contact(new Contact("chenS", "", "chens.work@foxmail.com"))//联系人信息
                .license("")//The Apache License
                .termsOfServiceUrl("https://swagger.io/")
                .version("1.0")
                .build();
    }

}
