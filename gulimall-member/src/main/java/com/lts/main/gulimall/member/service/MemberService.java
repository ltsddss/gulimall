package com.lts.main.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-23 19:26:55
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

