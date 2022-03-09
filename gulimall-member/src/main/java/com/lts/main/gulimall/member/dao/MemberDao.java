package com.lts.main.gulimall.member.dao;

import com.lts.main.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-23 19:26:55
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
