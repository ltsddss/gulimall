package com.lts.main.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.gulimall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-23 19:54:05
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

