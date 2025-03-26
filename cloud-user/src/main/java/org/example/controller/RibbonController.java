package org.example.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author sunhao
 * @date 2025/1/6
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/test")
    public String test() {
        String url = "http://cloudOrder/order/V1/get";
        return restTemplate.postForObject(url,null, String.class);
    }

    @PostMapping("/test1")
    public String ribbon() {
        ServiceInstance choose = loadBalancerClient.choose("cloudOrder");
        System.out.println("host:" + choose.getHost() + ",port:" + choose.getPort() + ",serviceId=" + choose.getServiceId() + ",uri=" + choose.getUri());
        return ("host:" + choose.getHost() + ",port:" + choose.getPort() + ",serviceId=" + choose.getServiceId() + ",uri=" + choose.getUri());
    }
}

