package com.hrc.cloudHystrixFeignConsumerOrder80.service.impl;

import com.hrc.cloudHystrixFeignConsumerOrder80.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 服务调用失败的时候默认会调用这里面的接口
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        //服务调用失败
        return "服务调用失败，ConsumerOrder80返回的错误信息，id:" + id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，ConsumerOrder80返回的错误信息，id:" + id;
    }
}
