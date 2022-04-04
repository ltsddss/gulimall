package com.lts.main.gulimall.product.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//导入mybatisplus的分页插件
@Configuration
@EnableTransactionManagement
@MapperScan("com/lts/main/gulimall/product/dao")
public class mybatisConfig {
//    已过期
//    @Bean
//    public PaginationInnerInterceptor paginationInterceptor() {
//        PaginationInnerInterceptor paginationInterceptor=new PaginationInnerInterceptor();
//
//        paginationInterceptor.setOverflow(true);
//
//        paginationInterceptor.setMaxLimit(1000L);
//        return paginationInterceptor;
//    }
@Bean
public MybatisPlusInterceptor innerInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
}
}
