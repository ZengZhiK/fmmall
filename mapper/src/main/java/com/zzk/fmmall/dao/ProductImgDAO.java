package com.zzk.fmmall.dao;

import com.zzk.fmmall.entity.ProductImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品图片  Mapper 接口
 * </p>
 *
 * @author zzk
 * @since 2022-01-15
 */
public interface ProductImgDAO extends BaseMapper<ProductImg> {
    /**
     * 根据商品Id查询对应的图片
     *
     * @param itemId
     * @return
     */
    List<ProductImg> selectByItemId(String itemId);
}
