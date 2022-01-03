package com.zzk.fmmall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.constant.HttpStatus;
import com.zzk.fmmall.dao.UserDAO;
import com.zzk.fmmall.entity.User;
import com.zzk.fmmall.exception.BusinessException;
import com.zzk.fmmall.service.UserService;
import com.zzk.fmmall.utils.MD5Utils;
import com.zzk.fmmall.vo.req.UserLoginVo;
import com.zzk.fmmall.vo.req.UserRegisterVo;
import com.zzk.fmmall.vo.resp.UserLoginRespVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2021-12-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void doRegister(UserRegisterVo userRegisterVo) {
        if (!userRegisterVo.getPassword().equals(userRegisterVo.getRepassword())) {
            throw new BusinessException("两次输入的密码不一致！", HttpStatus.BAD_REQUEST);
        } else if (!checkUserNameUnique(userRegisterVo.getUsername())) {
            throw new BusinessException("用户名被注册！", HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setUsername(userRegisterVo.getUsername());
            user.setPassword(MD5Utils.md5(userRegisterVo.getPassword()));
            user.setUserImg("img/default.png");
            user.setUserRegtime(LocalDateTime.now());
            user.setUserModtime(LocalDateTime.now());
            userDAO.insert(user);
        }
    }

    @Override
    public UserLoginRespVo doLogin(UserLoginVo userLoginVo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userLoginVo.getUsername());
        List<User> users = userDAO.selectList(wrapper);

        if (ObjectUtil.isEmpty(users)) {
            throw new BusinessException("登录用户：" + userLoginVo.getUsername() + " 不存在！", HttpStatus.BAD_REQUEST);
        } else if (users.size() != 1) {
            throw new BusinessException("登录用户：" + userLoginVo.getUsername() + " 不唯一！", HttpStatus.BAD_REQUEST);
        } else {
            User user = users.get(0);
            if (!user.getPassword().equals(MD5Utils.md5(userLoginVo.getPassword()))) {
                throw new BusinessException("密码输入错误！", HttpStatus.BAD_REQUEST);
            }
            UserLoginRespVo userLoginRespVo = new UserLoginRespVo();
            BeanUtils.copyProperties(user, userLoginRespVo);
            return userLoginRespVo;
        }
    }

    /**
     * 检查用户名是否唯一
     *
     * @param username
     * @return 返回true表示唯一，返回false表示不唯一
     */
    private boolean checkUserNameUnique(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Integer count = userDAO.selectCount(wrapper);
        return count == 0;
    }
}
