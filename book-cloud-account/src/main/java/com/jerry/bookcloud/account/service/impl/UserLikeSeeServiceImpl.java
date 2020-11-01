package com.jerry.bookcloud.account.service.impl;

import com.jerry.bookcloud.account.service.UserLikeSeeService;
import com.jerry.bookcloud.common.result.Result;
import org.springframework.stereotype.Service;

@Service
public class UserLikeSeeServiceImpl implements UserLikeSeeService {
    /**
     * 喜欢点击处理
     *
     * @param userId
     * @param bookId
     * @param value  0.取消喜欢，1.喜欢
     * @return
     */
    @Override
    public Result likeSeeClick(Integer userId, String bookId, Integer value) {
        return null;
    }

    /**
     * 获取图书喜欢数量
     *
     * @param bookId
     * @return
     */
    @Override
    public Result<Integer> getBookLikesCount(String bookId) {
        return null;
    }

    /**
     * 获取用户喜欢列表
     *
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Result getUserLikeBookList(Integer userId, Integer page, Integer limit) {
        return null;
    }

    /**
     * 用户是否喜欢此书
     *
     * @param userId
     * @param bookId
     * @return
     */
    @Override
    public Result userLikeThisBook(Integer userId, String bookId) {
        return null;
    }
}
