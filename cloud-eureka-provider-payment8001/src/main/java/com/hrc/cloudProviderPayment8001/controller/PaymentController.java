package com.hrc.cloudProviderPayment8001.controller;

import com.hrc.cloudProviderPayment8001.service.PaymentService;
import com.hrc.cloudApiCommons.entities.CommonResult;
import com.hrc.cloudApiCommons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //获取yml中设置的端口号并赋值给serverPort
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery() {

        //获取微服务实例下对应的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("getInstanceId:{},getHost：{}，getPort：{}",
                    instance.getInstanceId(),instance.getHost(),instance.getPort());
        }

        //获取当前注册中心所有的微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}",service);
        }
        return discoveryClient;
    }

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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
