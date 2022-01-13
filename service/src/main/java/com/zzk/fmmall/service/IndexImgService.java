package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.IndexImg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
public interface IndexImgService extends IService<IndexImg> {
    /**
     * 查询所有轮播图
     *
     * @return
     */
    AjaxResult listCarousels();
}
