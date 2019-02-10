package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${name}")
    String name;
    @Value("${age}")
    Integer age;
    @RequestMapping("/hello")
    public String hello() {
        return "name: "+name+" age: "+age;
    }
}
