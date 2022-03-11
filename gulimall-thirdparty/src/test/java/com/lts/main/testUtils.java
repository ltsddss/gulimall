package com.lts.main;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Scanner;

@SpringBootTest
public class testUtils {

//    测试redis的链接

    @Test
    public void testRedis() {
        Jedis redis = new Jedis("101.133.149.79", 6379);

//        测试通过
        System.out.println(redis.ping());
    }

    @Test
    public void testpone(){
//        输入手机号
        String phone="123456789";

//        判断手机号的次数，并且发送验证码
        String p=phoneCode(phone);

        if(p.equals("每天只能发送三次")){
            System.out.println(p);
        }
        else {
            System.out.println(p);
            Scanner scanner=new Scanner(System.in);
            if(rightCode(phone,scanner.nextInt()+"")){
                System.out.println("验证成功");
            }else {
                System.out.println("验证失败");
            }
        }

//
    }

    public String phoneCode(String phone) {
//        要求：输入手机号，点击随机发送一个6位数的验证码，2分钟内有效


//        输入验证码点击验证，返回成功或失败

//        每个手机号每天只能输入3次
//        手机发送次数
        String countKey ="verify"+phone+":count";
//        验证码Key
        String codeKey="verify"+phone+":code";

//        判断手机号是否存在
        Jedis jedis=new Jedis("101,133.149.79",6379);

        if(jedis.get(codeKey)==null){
//            设置手机的发送次数为1且设置过期时间为1天
            jedis.setex(countKey,24*60*60,"1");
        }
        else if(Integer.parseInt(jedis.get(codeKey))<=2){
//            让countKey的值加一
            jedis.incr(codeKey);
        }else {
            return "每天只能发送三次";
        }

//        将验证码发送到redis里面
        jedis.setex(codeKey,2*60,getCode());

        jedis.close();
        return "发送验证码成功";
    }

//    判断验证码是否正确
    public Boolean rightCode(String phone,String code){
        Jedis jedis=new Jedis("101,133.149.79",6379);
        if(jedis.get("verify"+phone+":code").equals(code)){
            jedis.close();
            return true;
        }
        jedis.close();
        return false;
    }

    public String getCode() {
//        使用Random获取10以内的数字，然后拼接为字符串
        Random random = new Random();

        String code = "";

        for (int i = 0; i < 6; i++) {
            int temp = random.nextInt(10);

            code = code + temp;
        }

        return code;
    }
}
