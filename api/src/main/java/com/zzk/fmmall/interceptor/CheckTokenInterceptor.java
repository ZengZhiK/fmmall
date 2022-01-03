package com.zzk.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.config.JwtTokenConfig;
import com.zzk.fmmall.constant.HttpStatus;
import com.zzk.fmmall.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zzk
 * @create 2022-01-03 10:29
 */
@Slf4j
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenConfig jwtTokenConfig;

    /**
     * 换行符
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String method = request.getMethod();
        if ("OPTIONS".equals(method)) {
            return true;
        }

        String token = request.getHeader("token");
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", method);
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印token
        log.info("TOKEN          : {}", token);

        if (!JwtTokenUtils.validateToken(token, jwtTokenConfig.getSecretKey())) {
            doResponse(response, AjaxResult.error(HttpStatus.UNAUTHORIZED, "令牌不合法！"));
            log.info("令牌校验失败！");
            log.info("=========================================== End ===========================================" + LINE_SEPARATOR);
            return false;
        }

        log.info("令牌校验成功！");
        log.info("=========================================== End ===========================================" + LINE_SEPARATOR);

        //返回 false 则请求中断
        return true;
    }

    private void doResponse(HttpServletResponse response, AjaxResult ajaxResult) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String json = new ObjectMapper().writeValueAsString(ajaxResult);
        out.print(json);
        out.flush();
        out.close();
    }
}
