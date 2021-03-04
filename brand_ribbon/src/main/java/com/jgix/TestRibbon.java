package com.jgix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test/")
public class TestRibbon {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("ribbon")
    public String test(){
        //当你进行了ribbon集成后
        String forObject = restTemplate.getForObject("http://TYPESERVER/type/test",String.class);
        return forObject;
    }


}
