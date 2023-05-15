package com.hrc.cloudProviderPayment8002.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrc.cloudProviderPayment8002.dao.PaymentMapper;
import com.hrc.cloudProviderPayment8002.service.PaymentService;
import com.hrc.cloudApiCommons.entities.Payment;
import com.hrc.cloudProviderPayment8002.dao.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
