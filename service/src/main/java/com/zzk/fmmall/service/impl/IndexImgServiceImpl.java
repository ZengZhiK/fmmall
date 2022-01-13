package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.dao.IndexImgDAO;
import com.zzk.fmmall.entity.IndexImg;
import com.zzk.fmmall.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
@Service
public class IndexImgServiceImpl extends ServiceImpl<IndexImgDAO, IndexImg> implements IndexImgService {
    @Autowired
    private IndexImgDAO indexImgDAO;

    @Override
    public AjaxResult listCarousels() {
        List<IndexImg> indexImgs = indexImgDAO.selectList(null);
        if (ObjectUtil.isEmpty(indexImgs)) {
            return AjaxResult.error("轮播图查询失败！");
        } else {
            return AjaxResult.success(indexImgs);
        }
    }
}
