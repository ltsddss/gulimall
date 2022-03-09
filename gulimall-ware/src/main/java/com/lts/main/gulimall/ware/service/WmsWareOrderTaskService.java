package com.lts.main.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.gulimall.ware.entity.WmsWareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-23 20:07:19
 */
public interface WmsWareOrderTaskService extends IService<WmsWareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

