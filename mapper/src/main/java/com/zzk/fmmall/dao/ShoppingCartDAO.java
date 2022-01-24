package com.zzk.fmmall.dao;

import com.zzk.fmmall.entity.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzk.fmmall.vo.resp.ShoppingCartVo;

import java.util.List;

/**
 * <p>
 * 购物车  Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2022-01-03
 */
public interface ShoppingCartDAO extends BaseMapper<ShoppingCart> {

    /**
     * 根据用户Id查询购物车
     *
     * @param userId
     * @return
     */
    List<ShoppingCartVo> selectShopcartByUserId(Integer userId);
}
