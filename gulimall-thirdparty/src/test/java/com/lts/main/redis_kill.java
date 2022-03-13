package com.lts.main;

import com.lts.main.thirdparty.controller.RedisController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class redis_kill {

//    主方法
    @Test
    public void redis_k(){
        RedisController redisController=new RedisController();

        System.out.println(redisController.testredis("123456","123456"));
    }

}
