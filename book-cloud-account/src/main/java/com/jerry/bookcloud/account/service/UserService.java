package com.jerry.bookcloud.account.service;

import com.jerry.bookcloud.account.model.User;
import com.jerry.bookcloud.common.result.Result;


public interface UserService {

    /**
     * 注册账户
     *
     * @param user
     * @return
     */
    Result register(User user);

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @return
     */
    Result login(String loginName, String password);

    /**
     * 退出登录
     *
     * @param loginName
     * @return
     */
    Result logout(String loginName);

    /**
     * 修改账户
     *
     * @param user
     * @return
     */
    Result update(User user);

    /**
     * 修改密码
     *
     * @param userBO
     * @return
     */
    Result updatePassword(User userBO);
}
