package com.hrc.myrule;

import com.hrc.myrule.rule.MyRoundRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 修改负载均衡算法不能被@ComponentScan扫描到
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        //return new RandomRule();//定义为随机
        return new MyRoundRule();
    }
}