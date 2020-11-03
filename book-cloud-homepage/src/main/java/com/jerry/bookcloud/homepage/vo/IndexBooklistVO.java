package com.jerry.bookcloud.homepage.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 书单VO
 * @author: zealon
 * @since: 2020/4/6
 */
public class IndexBooklistVO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;

    /** 名称 */
    private String name;

    /**
     * 书单样式：1.横版(2*4),2.竖版(1*3),3.1+4,4.竖版more
     */
    private Integer style;

    /**
     * 更多类型：1.无,2.更多,3.换一换
     */
    private Integer moreType;

    /** 更多链接 */
    private String moreUrl;

    /** 换一换随机编码 */
    private Integer randomNumber;

    /** 榜单图书 */
    private List<BooklistBookVO> books;

    /** 是否显示喜欢看 */
    private Boolean showLikeCount;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getMoreType() {
        return moreType;
    }

    public void setMoreType(Integer moreType) {
        this.moreType = moreType;
    }

    public String getMoreUrl() {
        return moreUrl;
    }

    public void setMoreUrl(String moreUrl) {
        this.moreUrl = moreUrl;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<BooklistBookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BooklistBookVO> books) {
        this.books = books;
    }

    public Boolean getShowLikeCount() {
        return showLikeCount;
    }

    public void setShowLikeCount(Boolean showLikeCount) {
        this.showLikeCount = showLikeCount;
    }
}
