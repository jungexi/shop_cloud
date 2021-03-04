package com.jgix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class HystrixTest {
    @Autowired
    private RestTemplate restTemplate;


    // 此注解标识是要熔断    fallbackMethod 熔断后进行执行的方法
    @HystrixCommand(fallbackMethod = "errorMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    }) //对此方法进行熔断
    @RequestMapping("hystrixtest")
    public String test(){
        //当你进行了ribbon集成后
        String forObject = restTemplate.getForObject("http://TYPESERVER/type/test",String.class);
        return forObject;
    }

    public String errorMethod(){

        return "失败";
    }



}
