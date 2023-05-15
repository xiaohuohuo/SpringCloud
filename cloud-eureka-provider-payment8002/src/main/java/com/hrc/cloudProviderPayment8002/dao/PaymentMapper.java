package com.hrc.cloudProviderPayment8002.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrc.cloudApiCommons.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
