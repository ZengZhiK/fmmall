package com.zzk.fmmall.dao;

import com.zzk.fmmall.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzk.fmmall.vo.resp.ProductVo;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2022-01-15
 */
public interface ProductDAO extends BaseMapper<Product> {
    /**
     * 查询3个推荐商品
     *
     * @return
     */
    List<ProductVo> selectRecommendProducts();
}
