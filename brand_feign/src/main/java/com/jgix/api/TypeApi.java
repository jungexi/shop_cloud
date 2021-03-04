package com.jgix.api;
//定义接口（和远程服务作对应）

import com.jgix.Exception.TypeException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//声明这是feign  value 服务提供者的服务名
@FeignClient(value = "TYPESERVER",fallback = TypeException.class)
public interface TypeApi {
    //定义此方法对应的远程接口
    @RequestMapping("type/test")
    public String testmethod1();

}
