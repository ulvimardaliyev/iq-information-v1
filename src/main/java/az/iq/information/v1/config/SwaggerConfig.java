package az.iq.information.v1.config;

import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableSwagger2
public class SwaggerConfig /*extends WebMvcConfigurerAdapter*/ {
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("az.iq.information.v1.controller"))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }*/



    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }*/

}
