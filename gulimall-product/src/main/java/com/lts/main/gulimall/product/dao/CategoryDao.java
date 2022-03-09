package com.lts.main.gulimall.product.dao;

import com.lts.main.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-21 17:26:01
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
