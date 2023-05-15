package com.hrc.cloudConsulProviderPayment8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CloudConsulProviderPayment8006Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulProviderPayment8006Application.class, args);
    }

}
