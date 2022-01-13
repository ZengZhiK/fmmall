package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.Category;
import com.zzk.fmmall.dao.CategoryDAO;
import com.zzk.fmmall.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.vo.resp.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDAO, Category> implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public AjaxResult listCategories() {
        List<CategoryVo> categories = categoryDAO.selectAllCategories();
        if (ObjectUtil.isEmpty(categories)) {
            return AjaxResult.error("轮播图查询失败！");
        } else {
            return AjaxResult.success(categories);
        }
    }
}
