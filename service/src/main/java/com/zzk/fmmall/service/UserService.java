package com.zzk.fmmall.service;

import com.zzk.fmmall.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzk.fmmall.vo.req.UserLoginVo;
import com.zzk.fmmall.vo.req.UserRegisterVo;
import com.zzk.fmmall.vo.resp.UserLoginRespVo;

/**
 * <p>
 * 用户  服务类
 * </p>
 *
 * @author zzk
 * @since 2021-12-22
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userRegisterVo
     */
    void doRegister(UserRegisterVo userRegisterVo);

    /**
     * 用户登录
     *
     * @param userLoginVo
     */
    UserLoginRespVo doLogin(UserLoginVo userLoginVo);
}
