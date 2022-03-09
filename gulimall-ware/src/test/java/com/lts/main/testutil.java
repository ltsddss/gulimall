package com.lts.main;

import com.lts.main.gulimall.ware.GulimallWareApplication;
import com.lts.main.gulimall.ware.entity.WmsWareSkuEntity;
import com.lts.main.gulimall.ware.service.WmsWareSkuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GulimallWareApplication.class)
public class testutil {

    @Autowired
    WmsWareSkuService wmsWareSkuService;

    @Test
    public void test(){
        WmsWareSkuEntity wmsWareSku=new WmsWareSkuEntity();

        wmsWareSku.setSkuName("bbb");

        wmsWareSkuService.save(wmsWareSku);

        System.out.println("打印成功");
    }
}
