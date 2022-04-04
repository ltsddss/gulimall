package com.lts.main.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.lts.main.gulimall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lts.main.gulimall.product.entity.AttrGroupEntity;
import com.lts.main.gulimall.product.service.AttrGroupService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.common.utils.R;



/**
 * 属性分组
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-21 17:57:11
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

//    注入三级分类的service
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/{categoryId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("categoryId") Long categoryId){
//        PageUtils page = attrGroupService.queryPage(params);
//        携带3级分类的查询
        PageUtils page=attrGroupService.queryPage(params,categoryId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
//        根据id查询信息
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
//         再查寻该id的全路径

        Long category=attrGroup.getCatelogId();

        Long[] catelogPath=categoryService.findcategoryPath(category);

        attrGroup.setCatelogPath(catelogPath);

        System.out.println(attrGroup);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
