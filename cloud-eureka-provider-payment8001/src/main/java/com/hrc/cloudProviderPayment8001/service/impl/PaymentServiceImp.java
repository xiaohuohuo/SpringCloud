package com.hrc.cloudProviderPayment8001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrc.cloudProviderPayment8001.dao.PaymentMapper;
import com.hrc.cloudProviderPayment8001.service.PaymentService;
import com.hrc.cloudApiCommons.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
