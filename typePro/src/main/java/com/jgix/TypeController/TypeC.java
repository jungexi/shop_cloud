package com.jgix.TypeController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type/")
public class TypeC {
    @RequestMapping("test")
    public String test() throws InterruptedException {
        Thread.sleep(600);
        return "type data is success  11111";
    }
}

