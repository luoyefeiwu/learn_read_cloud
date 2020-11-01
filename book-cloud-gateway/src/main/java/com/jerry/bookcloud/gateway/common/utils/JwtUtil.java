package com.jerry.bookcloud.gateway.common.utils;

import com.jerry.bookcloud.common.pojo.account.User;
import com.jerry.bookcloud.common.result.Result;
import com.jerry.bookcloud.common.result.ResultUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import static com.jerry.bookcloud.common.constant.JwtConstant.SECRET_KEY;

public class JwtUtil {

    /**
     * 身份认证
     * @param jwt 令牌
     * @return 成功状态返回200，其它均为失败
     */
    public static Result<User> validationToken(String jwt) {
        try {
            //解析JWT字符串中的数据，并进行最基础的验证
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();
            User user = new User();
            user.setUuid(claims.get("uuid").toString());
            user.setLoginName(claims.get("loginName").toString());
            user.setNickName(claims.get("nickName").toString());
            if (claims.get("phoneNumber") != null) {
                user.setPhoneNumber(claims.get("phoneNumber").toString());
            }
            user.setId(Integer.parseInt(claims.get("id").toString()));
            user.setHeadImgUrl(claims.get("headImgUrl").toString());
            return ResultUtil.success(user);
        } catch (ExpiredJwtException e) {
            // 已过期令牌
            return ResultUtil.authExpired();
        } catch (SignatureException e) {
            // 伪造令牌
            return ResultUtil.unAuthorized();
        } catch (Exception e) {
            // 系统错误
            return ResultUtil.unAuthorized();
        }
    }
}
