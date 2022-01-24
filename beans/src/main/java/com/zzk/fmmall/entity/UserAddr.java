package com.zzk.fmmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户地址 
 * </p>
 *
 * @author zzk
 * @since 2022-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址主键id
     */
    @TableId(value = "addr_id", type = IdType.AUTO)
    private String addrId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人手机号
     */
    private String receiverMobile;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String area;

    /**
     * 详细地址
     */
    private String addr;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 状态,1正常，0无效
     */
    @TableLogic
    private Integer status;

    /**
     * 是否默认地址 1是 1:是  0:否
     */
    private Integer commonAddr;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
