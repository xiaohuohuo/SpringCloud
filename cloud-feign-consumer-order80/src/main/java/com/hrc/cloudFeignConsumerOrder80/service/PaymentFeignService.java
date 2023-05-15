package com.hrc.cloudFeignConsumerOrder80.service;

import com.hrc.cloudApiCommons.entities.CommonResult;
import com.hrc.cloudApiCommons.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
//使用Feign,value为要调用的微服务名
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")//要调用的微服务的地址
    CommonResult getPaymentById(@PathVariable("id") Long id);

}
