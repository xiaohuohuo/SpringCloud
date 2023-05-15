package com.hrc.cloudHystrixFeignConsumerOrder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableHystrix//启用Hystrix断路器、服务降级
public class CloudHystrixFeignConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixFeignConsumerOrder80Application.class, args);
    }

}
