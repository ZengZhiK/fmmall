package com.zzk.fmmall.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel("购物车Vo")
public class ShoppingCartVo {
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品Id", required = true)
    @NotBlank(message = "商品Id不能为空！")
    private String productId;

    /**
     * skuID
     */
    @ApiModelProperty(value = "SKU Id", required = true)
    @NotBlank(message = "SKU Id不能为空！")
    private String skuId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户Id", required = true)
    @NotBlank(message = "用户Id不能为空！")
    private String userId;

    /**
     * 购物车商品数量
     */
    @ApiModelProperty(value = "购物车商品数量", required = true)
    @NotBlank(message = "购物车商品数量不能为空！")
    private String cartNum;

    /**
     * 添加购物车时商品价格
     */
    @ApiModelProperty(value = "商品价格", required = true)
    @NotNull(message = "商品价格不能为空！")
    private BigDecimal productPrice;

    /**
     * 选择的套餐的属性
     */
    @ApiModelProperty(value = "套餐属性", required = true)
    @NotBlank(message = "套餐属性不能为空！")
    private String skuProps;


}
