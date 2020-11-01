package com.jerry.bookcloud.gateway.controller;

import com.jerry.bookcloud.common.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import com.jerry.bookcloud.common.result.Result;

/**
 * 快速失败接口
 */
public class FallbackController {

    @GetMapping("/fallback")
    public Result fallback() {
        return ResultUtil.fail();
    }
}
