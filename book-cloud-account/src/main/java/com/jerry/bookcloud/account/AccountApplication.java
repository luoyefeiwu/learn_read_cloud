package com.jerry.bookcloud.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.jerry.bookcloud.account", "com.jerry.bookcloud.common"})
public class AccountApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccountApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
