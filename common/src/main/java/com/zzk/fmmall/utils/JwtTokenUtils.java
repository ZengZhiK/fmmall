package com.zzk.fmmall.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

/**
 * Jwt Token Utils
 *
 * @author zzk
 * @create 2020-12-22 11:36
 */
public class JwtTokenUtils {
    /**
     * 生成 access_token
     *
     * @param subject 代表这个JWT的主体，即它的所有人 一般是用户id
     * @param claims  存储在JWT里面的信息 一般放些用户的权限/角色信息
     * @return java.lang.String
     */
    public static String getAccessToken(String issuer, String subject, Map<String, Object> claims, Duration accessTokenExpireTime, String secretKey) {
        return generateToken(issuer, subject, claims, accessTokenExpireTime.toMillis(), secretKey);
    }

    // 上面我们已经有生成 access_token 的方法，下面加入生成 refresh_token 的方法(PC 端过期时间短一些)

    /**
     * 生产 PC refresh_token
     *
     * @param subject 代表这个JWT的主体，即它的所有人 一般是用户id
     * @param claims  存储在JWT里面的信息 一般放些用户的权限/角色信息
     * @return java.lang.String
     */
    public static String getRefreshToken(String issuer, String subject, Map<String, Object> claims, Duration refreshTokenExpireTime, String secretKey) {
        return generateToken(issuer, subject, claims, refreshTokenExpireTime.toMillis(), secretKey);
    }

    //上面我们已经有生成 access_token 的方法，下面加入生成 refresh_token 的方法(APP 端过期时间长一些)

    /**
     * 生产 App端 refresh_token
     *
     * @param subject 代表这个JWT的主体，即它的所有人 一般是用户id
     * @param claims  存储在JWT里面的信息 一般放些用户的权限/角色信息
     * @return java.lang.String
     */
    public static String getRefreshAppToken(String issuer, String subject, Map<String, Object> claims, Duration refreshTokenExpireAppTime, String secretKey) {
        return generateToken(issuer, subject, claims, refreshTokenExpireAppTime.toMillis(), secretKey);
    }

    /**
     * 签发token
     *
     * @param issuer    签发人
     * @param subject   代表这个JWT的主体，即它的所有人 一般是用户id
     * @param claims    存储在JWT里面的信息 一般放些用户的权限/角色信息
     * @param ttlMillis 有效时间(毫秒)
     * @param secretKey    密钥
     * @return java.lang.String
     */
    public static String generateToken(String issuer, String subject, Map<String, Object> claims, long ttlMillis, String secretKey) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] signingKey = DatatypeConverter.parseBase64Binary(secretKey);

        JwtBuilder builder = Jwts.builder();
        builder.setHeaderParam("typ", "JWT");
        if (!StringUtils.isEmpty(issuer)) {
            builder.setIssuer(issuer);
        }
        if (!StringUtils.isEmpty(subject)) {
            builder.setSubject(subject);
        }
        if (claims != null) {
            builder.setClaims(claims);
        }
        builder.setIssuedAt(now);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        builder.signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return io.jsonwebtoken.Claims
     */
    public static Claims getClaimsFromToken(String token, String secretKey) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).getBody();
        } catch (ClaimJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    /**
     * 获取用户id
     *
     * @param token 令牌
     * @return java.lang.String
     */
    public static String getUserId(String token, String secretKey) {
        Claims claims = getClaimsFromToken(token, secretKey);
        return claims.getSubject();
    }


    /**
     * 验证token 是否过期(true:已过期 false:未过期)
     *
     * @param token 令牌
     * @return java.lang.Boolean
     */
    public static Boolean isTokenExpired(String token, String secretKey) {
        Claims claims = getClaimsFromToken(token, secretKey);
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 校验令牌(true：验证通过 false：验证失败)
     *
     * @param token 令牌
     * @return java.lang.Boolean
     */
    public static Boolean validateToken(String token, String secretKey) {
        Claims claimsFromToken = getClaimsFromToken(token, secretKey);
        return (claimsFromToken != null && !isTokenExpired(token, secretKey));
    }

    /**
     * 获取token的剩余过期时间
     *
     * @param token 令牌
     * @return long
     */
    public static long getRemainingTime(String token, String secretKey) {
        long nowMillis = System.currentTimeMillis();
        return getClaimsFromToken(token, secretKey).getExpiration().getTime() - nowMillis;
    }
}
