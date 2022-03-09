package com.lts.main.gulimall.member.fegin;

import com.lts.main.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用feign进行远程调用
 * 声明每一个服务都是调用的哪一个服务的哪个接口
 */
@FeignClient("gulimall-coupon")
public interface CouponFeginServer {
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
