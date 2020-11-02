package com.jerry.book.cloud.account.feign.fallback;

import com.jerry.book.cloud.account.feign.client.LikeSeeClient;
import com.jerry.bookcloud.common.result.Result;
import com.jerry.bookcloud.common.result.ResultUtil;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 喜欢看客户端feign接口快速失败
 */
@Component
public class LikeSeeClientFallBack implements FallbackFactory<LikeSeeClient> {
    private static final Logger logger = LoggerFactory.getLogger(LikeSeeClientFallBack.class);


    @Override
    public LikeSeeClient create(Throwable throwable) {
        return new LikeSeeClient() {
            @Override
            public Result<Integer> getBookLikesCount(String bookId) {
                logger.error("获取喜欢看[{}]数量失败：{}", bookId, throwable.getMessage());
                return ResultUtil.success(0);
            }
        };
    }
}
