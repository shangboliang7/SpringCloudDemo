package org.example.client.orderClient;

/**
 * @author sunhao
 * @date 2024/12/26
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("cloudOrder")
@RequestMapping("/order/V1")
public interface TestOrderClient {
    @PostMapping("/get")
    public String get();
}

