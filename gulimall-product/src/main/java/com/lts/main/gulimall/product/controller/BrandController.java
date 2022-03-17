package com.lts.main.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.lts.main.common.valid.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lts.main.gulimall.product.entity.BrandEntity;
import com.lts.main.gulimall.product.service.BrandService;
import com.lts.main.common.utils.PageUtils;
import com.lts.main.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-21 17:57:10
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存 开启JER303校验后绑定一个BingingResult就可以获得校验结果
     * Springboot提供了注解，可以统一将异常集中处理也可以创建一个类
     * jre303使用分组校验，配置接口所在的组,当检验规则上出现新增组的规则时就会校验，没有则不校验
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Validated(value = AddGroup.class) @RequestBody BrandEntity brand){

//        Map<String,String> map=new HashMap<>();
//        if(result.hasErrors()){
//            //        获取到对应的错误信息进行判断
//            result.getFieldErrors().forEach((item)->{
////            获取错误提示
//                String message = item.getDefaultMessage();
////            获取错误属性的名称
//                String field = item.getField();
//
//                map.put(field,message);
//            });
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }
//        else {
            brandService.save(brand);

            return R.ok();
//        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    在entity的实体类下写的校验规则要在这里开启校验，不然Controller时不会进行校验的
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
