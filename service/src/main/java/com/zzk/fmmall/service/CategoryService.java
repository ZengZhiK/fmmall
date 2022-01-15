package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
public interface CategoryService extends IService<Category> {
    /**
     * 查询分类列表
     *
     * @return
     */
    AjaxResult listCategories();

    /**
     * 根据1级分类查询6个推荐商品
     *
     * @return
     */
    AjaxResult listRecommendProductsByFirstLevelCategories();
}
