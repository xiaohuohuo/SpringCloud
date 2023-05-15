package com.hrc.cloudZookeeperConsumerzkOrder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CloudZookeeperConsumerzkOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZookeeperConsumerzkOrder80Application.class, args);
    }

}
