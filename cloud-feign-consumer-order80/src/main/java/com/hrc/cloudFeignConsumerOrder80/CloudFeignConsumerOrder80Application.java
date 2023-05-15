package com.hrc.cloudFeignConsumerOrder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients//打开Feign
public class CloudFeignConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudFeignConsumerOrder80Application.class, args);
    }

}
