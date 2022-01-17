package com.zzk.fmmall.service.impl;

import com.zzk.fmmall.entity.ProductSku;
import com.zzk.fmmall.dao.ProductSkuDAO;
import com.zzk.fmmall.service.ProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-17
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuDAO, ProductSku> implements ProductSkuService {

}
