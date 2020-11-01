package com.jerry.bookcloud.account.controller;

import com.jerry.bookcloud.account.bo.UserBO;
import com.jerry.bookcloud.account.service.UserService;
import com.jerry.bookcloud.account.vo.AuthVO;
import com.jerry.bookcloud.common.request.RequestParams;
import com.jerry.bookcloud.common.result.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @param params
     * @return
     */

    @ApiOperation(value = "用户登录", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码", required = true, dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 200, message = "", response = Result.class)})
    @PostMapping("/login")
    public Result<AuthVO> login(@RequestBody RequestParams params) {
        String loginName = params.getStringValue("loginName");
        String password = params.getStringValue("password");
        return this.userService.login(loginName, password);
    }
}
