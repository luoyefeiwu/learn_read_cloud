package com.jerry.bookcloud.account.controller;

import com.jerry.bookcloud.account.bo.UserBO;
import com.jerry.bookcloud.account.service.UserService;
import com.jerry.bookcloud.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户服务接口")
@RestController
@RequestMapping("account/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册用户", httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200, message = "", response = Result.class)})
    @PostMapping("/register")
    public Result register(@RequestBody UserBO userBO) {
        return this.userService.register(userBO);
    }

}
