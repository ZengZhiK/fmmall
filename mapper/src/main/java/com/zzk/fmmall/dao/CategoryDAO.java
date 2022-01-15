package com.zzk.fmmall.dao;

import com.zzk.fmmall.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzk.fmmall.vo.resp.CategoryProductVo;
import com.zzk.fmmall.vo.resp.CategoryVo;

import java.util.List;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
public interface CategoryDAO extends BaseMapper<Category> {

    /**
     * 查询分类列表
     *
     * @return
     */
    List<CategoryVo> selectAllCategories();

    /**
     * 根据1级分类查询6个推荐商品
     *
     * @return
     */
    List<CategoryProductVo> selectRecommendProductsByFirstLevelCategories();
}
