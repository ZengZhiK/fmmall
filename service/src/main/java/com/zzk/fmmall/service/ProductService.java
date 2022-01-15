package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-15
 */
public interface ProductService extends IService<Product> {
    /**
     * 查询3个推荐商品
     *
     * @return
     */
    AjaxResult listRecommendProducts();
}
