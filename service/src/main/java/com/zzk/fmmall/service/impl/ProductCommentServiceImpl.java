package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.ProductComment;
import com.zzk.fmmall.dao.ProductCommentDAO;
import com.zzk.fmmall.service.ProductCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.vo.resp.ProductCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * <p>
 * 商品评价  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-18
 */
@Service
public class ProductCommentServiceImpl extends ServiceImpl<ProductCommentDAO, ProductComment> implements ProductCommentService {
    @Autowired
    private ProductCommentDAO productCommentDAO;

    @Override
    public AjaxResult listCommentsByProductId(String productId, int pageNum, int limit) {
        Page<ProductCommentVo> page = new Page<>(pageNum, limit);
        QueryWrapper<ProductCommentVo> wrapper = new QueryWrapper<>();
        IPage<ProductCommentVo> pageList = productCommentDAO.selectProductCommentVoByPage(page, productId, wrapper);
        if (ObjectUtil.isNotNull(pageList)) {
            return AjaxResult.success(pageList);
        } else {
            return AjaxResult.error("查询商品评价失败！");
        }
    }

    @Override
    public AjaxResult getCommentsCountByProductId(String productId) {
        QueryWrapper<ProductComment> countWrapper = new QueryWrapper<>();
        countWrapper.eq("product_id", productId);
        Integer total = productCommentDAO.selectCount(countWrapper);

        QueryWrapper<ProductComment> goodWrapper = new QueryWrapper<>();
        goodWrapper.eq("product_id", productId);
        goodWrapper.eq("comm_type", 1);
        Integer goodTotal = productCommentDAO.selectCount(goodWrapper);

        QueryWrapper<ProductComment> midWrapper = new QueryWrapper<>();
        midWrapper.eq("product_id", productId);
        midWrapper.eq("comm_type", 0);
        Integer midTotal = productCommentDAO.selectCount(midWrapper);

        QueryWrapper<ProductComment> badWrapper = new QueryWrapper<>();
        badWrapper.eq("product_id", productId);
        badWrapper.eq("comm_type", -1);
        Integer badTotal = productCommentDAO.selectCount(badWrapper);

        BigDecimal percent = BigDecimal.valueOf((goodTotal.doubleValue() / total.doubleValue()) * 100);

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("goodTotal", goodTotal);
        map.put("midTotal", midTotal);
        map.put("badTotal", badTotal);
        map.put("percent", percent.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        return AjaxResult.success(map);
    }
}
