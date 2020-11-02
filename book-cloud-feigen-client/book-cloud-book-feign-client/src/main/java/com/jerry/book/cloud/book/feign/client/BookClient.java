package com.jerry.book.cloud.book.feign.client;

import com.jerry.book.cloud.book.feign.fallback.BookClientFallBack;
import com.jerry.bookcloud.common.pojo.book.Book;
import com.jerry.bookcloud.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 图书客户端feign接口
 */
@FeignClient(contextId = "book", name = "book-cloud-book-feign-client", fallbackFactory = BookClientFallBack.class)
public interface BookClient {
    @RequestMapping("/book/getBookById")
    Result<Book> getBookById(@RequestParam("bookId") String bookId);

}
