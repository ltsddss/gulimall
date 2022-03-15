package com.lts.main.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 对于产品表设置逻辑删除字段（配置mybatisplus）
 */
@MapperScan("com/lts/main/gulimall/product/dao")
@SpringBootApplication(scanBasePackages = "com.lts.main.gulimall")
@EnableDiscoveryClient
public class GulimallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class,args);
    }
}
