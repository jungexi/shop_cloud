package com.jgix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient //声明是eureka的客户端
@EnableHystrix// 熔断器  需要两个注解
@EnableCircuitBreaker
public class HystrixApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(HystrixApp.class,args);
    }

    @Bean
    @LoadBalanced
        //声明 ribbon （并对resttemmplate进行负载均衡   调用的时候直接写服务名就行  不用写ip和端口）
    RestTemplate restTemplate() {
        return new RestTemplate();// RestTemplate对httpclient发送请求 进行封装了
    }
}
