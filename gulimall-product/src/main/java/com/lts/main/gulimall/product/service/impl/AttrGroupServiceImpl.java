package com.lts.main.gulimall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.common.utils.Query;

import com.lts.main.gulimall.product.dao.AttrGroupDao;
import com.lts.main.gulimall.product.entity.AttrGroupEntity;
import com.lts.main.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long categoryId) {
//        当categoryId为0时返回所有分页数据
        if(categoryId==0){
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>()
            );

            return new PageUtils(page);
        }
        else{
//            如果categoryId不为0，则返回目标值

//            获取筛选条件
            String key=(String) params.get("key");

            //            构造查询条件
            QueryWrapper<AttrGroupEntity> wrapper=new QueryWrapper<>();

            wrapper.eq("catelog_id",categoryId);
//            如果条件不为空，则继续构造条件
            if(!StringUtils.isNullOrEmpty(key)){
                wrapper.and((obj)->{
                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                });
//              select * from pms_attr_group where categoryId=? and (attr_group_id=key or attr_group_name=key)
            }
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
            return new PageUtils(page);
        }
    }

}