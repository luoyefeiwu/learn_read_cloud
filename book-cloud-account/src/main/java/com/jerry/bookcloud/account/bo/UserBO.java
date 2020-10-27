package com.jerry.bookcloud.account.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户业务对象
 * @author: zealon
 * @since: 2020/4/11
 */
@ApiModel(value = "用户注册信息")
public class UserBO {
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名(至少4个字符)", example = "yangguo")
    private String loginName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", example = "123321")
    private String userPwd;

    /**
     * 中文名
     */
    @ApiModelProperty(value = "昵称", example = "杨过")
    private String nickName;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "手机", example = "13800138000")
    private String phoneNumber;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
