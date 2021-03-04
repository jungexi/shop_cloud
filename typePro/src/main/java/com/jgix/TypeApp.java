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
@EnableEurekaClient //声明是eureka的客户端
public class TypeApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(TypeApp.class,args);
    }
}
