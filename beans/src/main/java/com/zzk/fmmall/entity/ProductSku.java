package com.zzk.fmmall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author zzk
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * sku编号
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private String skuId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * sku图片
     */
    private String skuImg;

    /**
     * 属性组合（格式是p1:v1;p2:v2）
     */
    private String untitled;

    /**
     * 原价
     */
    private Integer originalPrice;

    /**
     * 销售价格
     */
    private Integer sellPrice;

    /**
     * 折扣力度
     */
    private BigDecimal discounts;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * sku状态(1启用，0禁用，-1删除)
     */
    @TableLogic
    private Integer status;


}
