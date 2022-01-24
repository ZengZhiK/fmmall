package com.zzk.fmmall.service;

import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.entity.UserAddr;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户地址  服务类
 * </p>
 *
 * @author zzk
 * @since 2022-01-24
 */
public interface UserAddrService extends IService<UserAddr> {

    /**
     * 根据用户Id查询收货地址
     *
     * @param userId
     * @return
     */
    AjaxResult listAddrsByUid(Integer userId);
}
