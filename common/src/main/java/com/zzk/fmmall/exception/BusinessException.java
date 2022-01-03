package com.zzk.fmmall.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务自定义异常类
 *
 * @author zzk
 * @create 2020-12-21 11:31
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 8491038227098216101L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public BusinessException() {
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
