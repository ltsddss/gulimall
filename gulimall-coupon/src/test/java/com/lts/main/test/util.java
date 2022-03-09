package com.lts.main.test;

import com.lts.main.gulimall.coupon.GulimallCouponApplication;
import com.lts.main.gulimall.coupon.entity.CouponEntity;
import com.lts.main.gulimall.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GulimallCouponApplication.class)
public class util {

    @Autowired
    CouponService couponService;

//    测试成功
    @Test
    public void test(){
        CouponEntity coupon=new CouponEntity();

        coupon.setNote("hhhh");

        couponService.save(coupon);

        System.out.println("打印成功");
    }
}
