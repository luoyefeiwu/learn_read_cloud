package com.jerry.bookcloud.homepage.service;

import com.jerry.bookcloud.common.result.Result;

/**
 * 主页服务
 */
public interface IndexPageConfigService {
    /**
     * 获取精品页VO
     *
     * @param type  页面数量（1.精品，2.男士,3.女士）
     * @param page
     * @param limit
     * @return
     */
    Result getIndexPageByType(Integer type, Integer page, Integer limit);
}
