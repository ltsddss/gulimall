package com.lts.main;

import com.lts.main.gulimall.order.GulimallOrderApplication;
import com.lts.main.gulimall.order.entity.OrderEntity;
import com.lts.main.gulimall.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GulimallOrderApplication.class)
public class testutil {

    @Autowired
    OrderService orderService;

    @Test
    public void test(){
        OrderEntity order=new OrderEntity();

        order.setDeliverySn("aaa");

        orderService.save(order);

        System.out.println("打印成功");
    }
}
