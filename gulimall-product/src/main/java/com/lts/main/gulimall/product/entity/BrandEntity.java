package com.lts.main.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.lts.main.common.valid.AddGroup;
import com.lts.main.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author lts
 * @email 419253381@qq.com
 * @date 2022-02-21 17:26:01
 */

/**
 * 添加校验注解（JSR303）
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 * 新增时必须为空，修改时必须不为空
	 */
	@TableId
	@NotEmpty(message = "修改时必须指定品牌id",groups = UpdateGroup.class)
	@Null(message = "新增时不能指定品牌id",groups = AddGroup.class)
	private Long brandId;
	/**
	 * 品牌名(校验--至少包含一个非空的字符)
	 */
	@NotEmpty(message = "名称不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo地址必须是一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */

	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "/^[a-zA-Z]$/",message = "首字母必须在a-z或A-Z之间")
	private String firstLetter;
	/**
	 * 排序 最小为0
	 */
	@Min(value = 0)
	private Integer sort;

}
