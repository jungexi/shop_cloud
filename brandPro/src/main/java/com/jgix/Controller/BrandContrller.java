package com.jgix.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

//调用类型服务的接口
@RestController
@RequestMapping("brand/")
public class BrandContrller {

    @Autowired
    private LoadBalancerClient loadBalancerClient;



    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("getData")
    public String getData(){
        //调用类型服务的接口
        String forObject = restTemplate.getForObject("http://localhost:9000/type/test", String.class);
        System.out.println("接口返回数据："+forObject);
        return "get data from brand  typeData";
    }
    //通过eureka的负载均衡
    @RequestMapping("getData2")
    public String getData2(){
//        //调用类型服务的接口
//        String forObject = restTemplate.getForObject("http://localhost:9000/type/test", String.class);
//        System.out.println("接口返回数据："+forObject);

        ServiceInstance serviceInstance = loadBalancerClient.choose("TYPESERVER");
        //得到一个可用的服务地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        System.out.println(url);
        return url;
    }
}
