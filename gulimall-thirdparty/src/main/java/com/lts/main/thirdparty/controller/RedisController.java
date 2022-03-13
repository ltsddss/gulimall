package com.lts.main.thirdparty.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Random;

@RestController
public class RedisController {

//    测试秒杀项目（接收测试的数据请求）
    @RequestMapping("/third_party/getIphone")
    public String testredis(String prodid,String userid){
        Jedis redis=new Jedis("101.133.149.79",6379);


//  首先设置redis中的商品库存为sk:prodid:qt
        String kcKey="sk:"+prodid+":qt";

        String userKey="sk:"+ prodid +":user";

        //    获取库存，如果库存为null表示还未开始

        if(redis.get(kcKey)==null){
            System.out.println(redis.get(kcKey));
            redis.close();
            return "秒杀还未开始";
        }
//    秒杀成功的用户的set集合（不可以重复秒杀）sk:prodid:user

        if(redis.sismember(userKey,userid)){
            redis.close();
            return "不可重复秒杀";
        }

//    判断库存是否清空，库存小于1秒杀结束
        if(Integer.parseInt(redis.get(kcKey))<1){
            redis.close();
            return "秒杀结束，很遗憾您未能抢到";
        }

//    秒杀过程：
//    库存减一
        redis.decr(kcKey);
//    ，用户名单加一
        redis.sadd(userKey,userid);

        return "秒杀成功";
    }
}
