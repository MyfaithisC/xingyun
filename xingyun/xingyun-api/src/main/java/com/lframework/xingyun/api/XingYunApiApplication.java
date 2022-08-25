package com.lframework.xingyun.api;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@ServletComponentScan(basePackages = "com.lframework")
@SpringBootApplication(scanBasePackages = "com.lframework")
@MapperScan("com.lframework.**.mappers")
public class XingYunApiApplication {

  public static void main(String[] args) {

    SpringApplication.run(XingYunApiApplication.class, args);
  }

  /**
   * Swagger 自定义配置信息 请自行修改
   */
  @Configuration
  public static class SwaggerApiConfiguration {

    @Bean(value = "defaultApi")
    public Docket defaultApi(OpenApiExtensionResolver openApiExtensionResolver) {


      // 使用spring-web兼容postman
      return new Docket(DocumentationType.SPRING_WEB)
              .apiInfo(apiInfo())
              .groupName("ERP")
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.lframework.xingyun"))
              .paths(PathSelectors.any())
              .build();
    }

    // 可以修改内容 但是不要删除这个Bean
    @Bean
    public ApiInfo apiInfo() {

      return new ApiInfoBuilder()
              .title("swagger-demo后台系统")
              .description("swagger后台模块")
              .contact("lframework@163.com")
              .version("1.0")
              .build();
    }
  }
}
