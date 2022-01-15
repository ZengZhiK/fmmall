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
    List<ProductImg> selectByItemId(int itemId);
}
