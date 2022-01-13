package com.zzk.fmmall.dao;

import com.zzk.fmmall.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
