package com.lts.main;

import com.lts.main.gulimall.member.GulimallMemberApplication;
import com.lts.main.gulimall.member.entity.MemberEntity;
import com.lts.main.gulimall.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GulimallMemberApplication.class)
public class testutil {

    @Autowired
    MemberService memberService;

    @Test
    public void testu(){
        MemberEntity member=new MemberEntity();

        member.setCity("china");

        memberService.save(member);

        System.out.println("打印成功");
    }
}
