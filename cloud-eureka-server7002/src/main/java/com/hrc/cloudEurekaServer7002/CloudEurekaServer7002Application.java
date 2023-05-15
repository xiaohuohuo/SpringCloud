package com.hrc.cloudEurekaServer7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class CloudEurekaServer7002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002Application.class, args);
    }

}
