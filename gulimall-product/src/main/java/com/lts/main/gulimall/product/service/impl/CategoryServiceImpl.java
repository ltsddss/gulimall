package com.lts.main.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.common.utils.Query;

import com.lts.main.gulimall.product.dao.CategoryDao;
import com.lts.main.gulimall.product.entity.CategoryEntity;
import com.lts.main.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
//        查出所有的商品服务
        List<CategoryEntity> entity=baseMapper.selectList(null);
//        处理entity类进行处理，找出所有的一级分类
        List<CategoryEntity> categoryEntities=entity.stream().filter((categoryEntity)->{
//            流式计算，将类中的ParentCid为0的数据提取出来成为一个list
            return categoryEntity.getParentCid()==0;
        }).map((menu)->{
            /**
             * 将查到的所有子菜单存入属性中
             */
            menu.setChildren(getchildren(menu,entity));
            return menu;
        }).sorted((menu1,menu2)->{
            /**
             * 根据两个比较的值来进行排序
             */
            return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return categoryEntities;
    }

    /**
     * 递归显示所有的子菜单
     * @return
     */
    private List<CategoryEntity> getchildren(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> categoryEntities=all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map((categoryEntity)->{
            /**
             * 递归寻找子菜单
             */
            categoryEntity.setChildren(getchildren(categoryEntity,all));
            return categoryEntity;
        }).sorted((categoryEntity1,categoryEntity2)->{
            /**
             * 菜单的排序（直接使用会爆出空值异常）
             */
            return (categoryEntity1.getSort()==null?0:categoryEntity1.getSort())-(categoryEntity2.getSort()==null?0:categoryEntity2.getSort());
        }).collect(Collectors.toList());

        return categoryEntities;
    }

}