package com.hrc.cloudHystrixConsumerDashboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard//打开服务监控仪表盘
public class CloudHystrixConsumerDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixConsumerDashboard9001Application.class, args);
    }

}
