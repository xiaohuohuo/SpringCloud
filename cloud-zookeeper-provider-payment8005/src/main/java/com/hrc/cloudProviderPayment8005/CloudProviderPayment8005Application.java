package com.hrc.cloudProviderPayment8005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CloudProviderPayment8005Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8005Application.class, args);
    }

}
