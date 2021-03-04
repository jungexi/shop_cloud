package com.jgix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class BrandApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(BrandApp.class,args);
    }
    @Bean //全局声明restTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
