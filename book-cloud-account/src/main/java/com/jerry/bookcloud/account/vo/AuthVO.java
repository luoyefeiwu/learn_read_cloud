package com.jerry.bookcloud.account.vo;

import lombok.Data;

/**
 * 认证VO
 *
 * @author: zealon
 * @since: 2020/4/14
 */
public class AuthVO {
    private String token;
    private UserVO user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }
}
