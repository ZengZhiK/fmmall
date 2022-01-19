package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.ProductComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品评价  服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-18
 */
public interface ProductCommentService extends IService<ProductComment> {
    /**
     * 分页查询商品评论
     *
     * @param productId
     * @param pageNum
     * @param limit
     * @return
     */
    AjaxResult listCommentsByProductId(String productId, int pageNum, int limit);
}
