package com.jgix.controller;

import com.jgix.api.TypeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test/")
@RestController
public class TestFeign {
    @Autowired
    private TypeApi typeApi;
    @RequestMapping("feign")
    public String test() throws InterruptedException {
        Thread.sleep(2000);
        String s = typeApi.testmethod1();
        return s;
    }
}
