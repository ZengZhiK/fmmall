package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.UserAddr;
import com.zzk.fmmall.dao.UserAddrDAO;
import com.zzk.fmmall.service.UserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户地址  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-01-24
 */
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrDAO, UserAddr> implements UserAddrService {

    @Autowired
    private UserAddrDAO userAddrDAO;

    @Override
    public AjaxResult listAddrsByUid(Integer userId) {
        QueryWrapper<UserAddr> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<UserAddr> userAddrs = userAddrDAO.selectList(wrapper);
        if (ObjectUtil.isEmpty(userAddrs)) {
            return AjaxResult.error("收货地址查询失败！");
        } else {
            return AjaxResult.success(userAddrs);
        }
    }
}
