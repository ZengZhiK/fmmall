package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.dao.ProductDAO;
import com.zzk.fmmall.entity.Product;
import com.zzk.fmmall.service.ProductService;
import com.zzk.fmmall.vo.resp.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDAO, Product> implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public AjaxResult listRecommendProducts() {
        List<ProductVo> productVos = productDAO.selectRecommendProducts();
        if (ObjectUtil.isEmpty(productVos)) {
            return AjaxResult.error("推荐商品查询失败！");
        } else {
            return AjaxResult.success(productVos);
        }
    }
}
