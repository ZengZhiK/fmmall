package com.zzk.fmmall.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zzk.fmmall.entity.ProductComment;
import com.zzk.fmmall.vo.resp.ProductCommentVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品评价  Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2022-01-18
 */
public interface ProductCommentDAO extends BaseMapper<ProductComment> {
    /**
     * 分页查询商品评论
     *
     * @param page
     * @param wrapper
     * @return
     */
    IPage<ProductCommentVo> selectProductCommentVoByPage(IPage<ProductCommentVo> page, @Param("productId") String productId, @Param(Constants.WRAPPER) Wrapper<ProductCommentVo> wrapper);
}
