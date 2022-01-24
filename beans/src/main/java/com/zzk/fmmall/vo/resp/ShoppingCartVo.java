package com.zzk.fmmall.vo.resp;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author zzk
 * @since 2022-01-03
 */
@Data
public class ShoppingCartVo {
    /**
     * 主键
     */
    private Integer cartId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * skuID
     */
    private String skuId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 购物车商品数量
     */
    private String cartNum;

    /**
     * 添加购物车时间
     */
    private String cartTime;

    /**
     * 添加购物车时商品价格
     */
    private BigDecimal productPrice;

    /**
     * 选择的套餐的属性
     */
    private String skuProps;

    /**
     * 商品名称 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productImg;

    /**
     * 原价
     */
    private double originalPrice;

    /**
     * 销售价格
     */
    private double sellPrice;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 库存
     */
    private int skuStock;
}
