package co.com.bancolombia.microservice.resolveEnigmaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.bancolombia.microservice.resolveEnigmaApi", "co.com.bancolombia._microservice.resolveEnigmaApi.api" , "co.com.bancolombia.microservice.resolveEnigmaApi.config"})
public class ResolveEnigmaApplication {


    public static void main(String[] args) throws Exception {
        new SpringApplication(ResolveEnigmaApplication.class).run(args);
    }

}
