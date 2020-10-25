package com.jerry.bookcloud.account.service.impl;

import com.jerry.bookcloud.account.dao.UserMapper;
import com.jerry.bookcloud.account.model.User;
import com.jerry.bookcloud.account.service.UserService;
import com.jerry.bookcloud.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;

    /**
     * 注册账户
     *
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {

        return null;
    }

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public Result login(String loginName, String password) {
        return null;
    }

    /**
     * 退出登录
     *
     * @param loginName
     * @return
     */
    @Override
    public Result logout(String loginName) {
        return null;
    }

    /**
     * 修改账户
     *
     * @param user
     * @return
     */
    @Override
    public Result update(User user) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param userBO
     * @return
     */
    @Override
    public Result updatePassword(User userBO) {
        return null;
    }
}
