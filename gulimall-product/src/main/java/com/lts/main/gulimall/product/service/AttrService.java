package com.lts.main.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-21 17:26:01
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

