package com.jerry.bookcloud.account.common.utils;

import com.jerry.bookcloud.account.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import static com.jerry.bookcloud.common.constant.JwtConstant.SECRET_KEY;

/**
 * JWT工具
 *
 * @author: zealon
 * @since: 2020/4/14
 */
public class JwtUtil {

    /**
     * 构建JWT对象
     *
     * @param expire
     * @param user
     * @return
     */
    public static String buildJwt(Date expire, User user) {
        String jwt = Jwts.builder()
                // 使用HS256加密算法
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                // 过期时间
                .setExpiration(expire)
                .claim("loginName", user.getLoginName())
                .claim("nickName", user.getNickName())
                .claim("phoneNumber", user.getPhoneNumber())
                .claim("headImgUrl", user.getHeadImgUrl())
                .claim("uuid", user.getUuid())
                .claim("id", user.getId())
                .compact();
        return jwt;
    }
}