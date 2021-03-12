package com.coe.engine.config;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@SuppressWarnings({"common-java:InsufficientBranchCoverage"})
public class SwaggerConfig {
    public static final String ERROR = "ServiceError";

    @Bean
    public Docket api () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage ("com.coe.engine.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageList())
                .globalResponseMessage(RequestMethod.PUT, responseMessageList())
                .globalResponseMessage(RequestMethod.POST, responseMessageList());
    }


    private ApiInfo getApiInfo () {
        final ApiInfo apiInfo = new ApiInfo (
                "Engine Project",
                "Engine Project is to help coe to do fiscal work.",
                null,
                null,
                null,
                null,
                null);
        return apiInfo;
    }

    private static List<ResponseMessage> responseMessageList() {
        return newArrayList(
                new ResponseMessageBuilder()
                        .code(HttpURLConnection.HTTP_BAD_REQUEST)
                        .message("Invalid Parameters")
                        .responseModel(new ModelRef(ERROR))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpURLConnection.HTTP_UNAUTHORIZED)
                        .message("User Not Authorized")
                        .responseModel(new ModelRef(ERROR))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpURLConnection.HTTP_NOT_FOUND)
                        .message("Resource Not Found")
                        .responseModel(new ModelRef(ERROR))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpURLConnection.HTTP_UNAVAILABLE)
                        .message("Service Unavailable")
                        .responseModel(new ModelRef(ERROR))
                        .build(),
                new ResponseMessageBuilder()
                        .code(HttpURLConnection.HTTP_INTERNAL_ERROR)
                        .message("Unknown Service Error")
                        .responseModel(new ModelRef(ERROR))
                        .build()
        );
    }
}
