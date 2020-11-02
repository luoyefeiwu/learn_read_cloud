package com.jerry.book.cloud.account.feign.client;


import com.jerry.book.cloud.account.feign.fallback.LikeSeeClientFallBack;
import com.jerry.bookcloud.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 喜欢看客户端feign接口
 */
@FeignClient(contextId = "like", name = "book-cloud-account", fallbackFactory = LikeSeeClientFallBack.class)
public interface LikeSeeClient {

    @GetMapping("/account/like-see/get-count")
    Result<Integer> getBookLikesCount(@RequestParam("bookId") String bookId);
}
