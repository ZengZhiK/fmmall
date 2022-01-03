package com.zzk.fmmall.vo.resp;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author zzk
 * @create 2021-12-31 11:08
 */
@Data
public class UserLoginRespVo {
    /**
     * 主键id 用户id
     */
    private Integer userId;

    /**
     * 用户名 用户名
     */
    private String username;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 真实姓名 真实姓名
     */
    private String realname;

    /**
     * 头像 头像
     */
    private String userImg;

    /**
     * 手机号 手机号
     */
    private String userMobile;

    /**
     * 邮箱地址 邮箱地址
     */
    private String userEmail;

    /**
     * 性别 M(男) or F(女)
     */
    private String userSex;

    /**
     * 生日 生日
     */
    private LocalDate userBirth;
}
