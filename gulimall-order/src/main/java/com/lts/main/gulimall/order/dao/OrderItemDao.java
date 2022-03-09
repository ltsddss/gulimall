package com.lts.main.gulimall.order.dao;

import com.lts.main.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-23 19:54:05
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
