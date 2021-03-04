package com.jgix.Exception;

import com.jgix.api.TypeApi;
import org.springframework.stereotype.Component;

@Component //将当前类 交给ioc管理
public class TypeException implements TypeApi {
    @Override
    public String testmethod1() {
        return "稍后再试";
    }
}
