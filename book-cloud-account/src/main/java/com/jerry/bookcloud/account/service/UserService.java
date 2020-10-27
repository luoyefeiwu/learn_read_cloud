package com.jerry.bookcloud.account.service;

import com.jerry.bookcloud.account.bo.UserBO;
import com.jerry.bookcloud.account.vo.AuthVO;
import com.jerry.bookcloud.common.result.Result;


public interface UserService {

    /**
     * 注册账户
     * @param userBO
     * @return
     */
    Result register(UserBO userBO);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    Result<AuthVO> login(String loginName, String password);

    /**
     * 退出登录
     * @param loginName
     * @return
     */
    Result logout(String loginName);

    /**
     * 修改账户
     * @param userBO
     * @return
     */
    Result update(UserBO userBO);

    /**
     * 修改密码
     * @param userBO
     * @return
     */
    Result updatePassword(UserBO userBO);
}
