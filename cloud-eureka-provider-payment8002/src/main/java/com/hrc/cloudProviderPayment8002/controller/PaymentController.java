package com.hrc.cloudProviderPayment8002.controller;

import com.hrc.cloudProviderPayment8002.service.PaymentService;
import com.hrc.cloudApiCommons.entities.CommonResult;
import com.hrc.cloudApiCommons.entities.Payment;
import com.hrc.cloudProviderPayment8002.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        if (save) {
            Map<String, Object> map = new HashMap<>();
            map.put("id",payment.getId());
            map.put("serverPort",serverPort);
            return CommonResult.success("插入成功",map);
        }

        return CommonResult.error("插入失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getById(id);
        log.info("*****查询结果:{},serverPort:{}",payment,serverPort);
        if (payment != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("payment",payment);
            map.put("serverPort",serverPort);
            return CommonResult.success("查询成功",map);
        }else{
            return CommonResult.error("没有对应记录,查询ID: "+id,null);
        }
    }

}
