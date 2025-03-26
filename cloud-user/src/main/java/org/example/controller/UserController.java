package org.example.controller;

import org.example.client.orderClient.TestOrderClient;
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
public class UserController {
    @Autowired
    private TestOrderClient testOrderClient;

    @PostMapping("/get")
    public String get() {
        return testOrderClient.get();
    }

}

