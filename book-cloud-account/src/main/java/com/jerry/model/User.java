package com.jerry.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "user")
public class User {


    @Id
    private Integer id;
    /**
     * 唯一id
     */
    @Column
    private String uuid;

    /**
     * 登录名
     */
    @Column
    private String loginName;

    /**
     * 中文名
     */
    @Column
    private String nickName;

    /**
     * 联系电话
     */
    @Column
    private String phoneNumber;

    /**
     * 头像
     */
    @Column
    private String headImgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
