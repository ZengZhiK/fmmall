package com.zzk.fmmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.dao.ShoppingCartDAO;
import com.zzk.fmmall.entity.ShoppingCart;
import com.zzk.fmmall.service.ShoppingCartService;
import com.zzk.fmmall.vo.req.ShoppingCartVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 购物车  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-03
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartDAO, ShoppingCart> implements ShoppingCartService {
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Override
    public AjaxResult addShoppingCart(ShoppingCartVo shoppingCartVo) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartVo, shoppingCart);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        shoppingCart.setCartTime(LocalDateTime.now().format(formatter));

        int insert = shoppingCartDAO.insert(shoppingCart);
        if (insert == 1) {
            return AjaxResult.success("添加购物车成功！");
        } else {
            return AjaxResult.error("添加购物车失败！");
        }
    }
}
