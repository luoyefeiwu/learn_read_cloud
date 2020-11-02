package com.jerry.book.cloud.book.feign.fallback;

import com.jerry.book.cloud.book.feign.client.BookClient;
import com.jerry.bookcloud.common.pojo.book.Book;
import com.jerry.bookcloud.common.result.Result;
import com.jerry.bookcloud.common.result.ResultUtil;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 图书客户端feign接口快速失败
 */
@Component
public class BookClientFallBack implements FallbackFactory<BookClient> {

    private static final Logger logger = LoggerFactory.getLogger(BookClient.class);

    @Override
    public BookClient create(Throwable throwable) {
        return new BookClient() {
            @Override
            public Result<Book> getBookById(String bookId) {
                logger.error("获取图书[{}]失败：{}", bookId, throwable.getMessage());
                return ResultUtil.success(null);
            }
        };
    }
}
