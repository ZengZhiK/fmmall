package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.constant.HttpStatus;
import com.zzk.fmmall.dao.ProductDAO;
import com.zzk.fmmall.dao.ProductImgDAO;
import com.zzk.fmmall.dao.ProductSkuDAO;
import com.zzk.fmmall.entity.Product;
import com.zzk.fmmall.entity.ProductImg;
import com.zzk.fmmall.entity.ProductSku;
import com.zzk.fmmall.service.ProductService;
import com.zzk.fmmall.vo.resp.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Autowired
    private ProductImgDAO productImgDAO;

    @Autowired
    private ProductSkuDAO productSkuDAO;

    @Override
    public AjaxResult listRecommendProducts() {
        List<ProductVo> productVos = productDAO.selectRecommendProducts();
        if (ObjectUtil.isEmpty(productVos)) {
            return AjaxResult.error("推荐商品查询失败！");
        } else {
            return AjaxResult.success(productVos);
        }
    }

    @Override
    public AjaxResult getProductBasicInfo(String productId) {
        QueryWrapper<Product> productWrapper = new QueryWrapper<>();
        productWrapper.eq("product_id", productId);
        productWrapper.eq("product_status", 1);
        Product product = productDAO.selectOne(productWrapper);

        if (ObjectUtil.isNotNull(product)) {
            List<ProductImg> productImgs = productImgDAO.selectByItemId(product.getProductId());

            QueryWrapper<ProductSku> skuWrapper = new QueryWrapper<>();
            skuWrapper.eq("product_id", productId);
            List<ProductSku> productSkus = productSkuDAO.selectList(skuWrapper);

            HashMap<String, Object> basicInfo = new HashMap<>();
            basicInfo.put("product", product);
            basicInfo.put("productImgs", productImgs);
            basicInfo.put("productSkus", productSkus);

            return AjaxResult.success(basicInfo);
        } else {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "查询的商品不存在！");
        }
    }
}
