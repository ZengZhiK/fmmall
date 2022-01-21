package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzk.fmmall.vo.req.ShoppingCartVo;

/**
 * <p>
 * 购物车  服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-03
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
    /**
     * 添加购物车
     *
     * @param shoppingCartVo
     * @return
     */
    AjaxResult addShoppingCart(ShoppingCartVo shoppingCartVo);
}
