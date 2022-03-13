package com.lts.main.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class thirdpartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(thirdpartyApplication.class,args);
    }
}
