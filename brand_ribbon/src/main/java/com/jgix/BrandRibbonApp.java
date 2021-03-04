package com.jgix;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient //针对注册中心为eureka   // 相同的注解  @enablediscoverClient  注册中心  可以为zookeeper  eureka

public class BrandRibbonApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(BrandRibbonApp.class,args);
    }
    @Bean
    @LoadBalanced
        //声明 ribbon （并对resttemmplate进行负载均衡   调用的时候直接写服务名就行  不用写ip和端口）
    RestTemplate restTemplate() {
        return new RestTemplate();// RestTemplate对httpclient发送请求 进行封装了
    }

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();	//这里配置策略，和配置文件对应
    }
}
