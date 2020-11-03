package com.jerry.bookcloud.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.jerry.bookcloud.homepage", "com.jerry.bookcloud.common", "com.jerry.book.cloud.book.feign", "com.jerry.book.cloud.account.feign"})
@EnableFeignClients(basePackages = {"com.jerry.book.cloud.book.feign", "com.jerry.book.cloud.account.feign"})
@EnableHystrix
@EnableHystrixDashboard
public class HomePageApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomePageApplication.class);
    }
}
