package org.example.controller;

import org.checkerframework.checker.units.qual.A;
import org.example.config.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunhao
 * @date 2024/12/26
 */
@RestController
@RequestMapping("/V1")
public class TestController {
//    @Value("${nacos.test}")
    private String test= "小王";
    @Autowired
    private OrderProperties orderProperties;
    @PostMapping("/get")
    public String get() {
        System.out.println(test);
        return test;
    }

    @PostMapping("/config")
    public String config() {
        return orderProperties.getHost();
    }

}

