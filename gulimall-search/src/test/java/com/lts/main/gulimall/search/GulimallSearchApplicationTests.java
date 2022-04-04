package com.lts.main.gulimall.search;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallSearchApplicationTests {

    @Autowired
    public RestHighLevelClient restHighLevelClient;
    @Test
    void contextLoads() {
    }

    @Test
    public void putindex(){
        System.out.println(restHighLevelClient);
    }
}
