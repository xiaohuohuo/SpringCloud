package com.hrc.cloudFeignConsumerOrder80.controller;

import com.hrc.cloudApiCommons.entities.CommonResult;
import com.hrc.cloudApiCommons.entities.Payment;
import com.hrc.cloudFeignConsumerOrder80.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }


}
