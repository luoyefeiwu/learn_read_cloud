package com.jerry.bookcloud.homepage.vo;

import java.io.Serializable;

/**
 * 精品页VO对象
 * @author: zealon
 * @since: 2020/4/6
 */
public class IndexPageVO implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 配置项类型：1.banner,2.榜单
     */
    private Integer itemType;

    /**
     * 榜单/banner id
     */
    private Integer itemId;

    /** Banner VO对象 */
    private IndexBannerVO banner;

    /** 榜单VO对象 */
    private IndexBooklistVO booklist;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public IndexBannerVO getBanner() {
        return banner;
    }

    public void setBanner(IndexBannerVO banner) {
        this.banner = banner;
    }

    public IndexBooklistVO getBooklist() {
        return booklist;
    }

    public void setBooklist(IndexBooklistVO booklist) {
        this.booklist = booklist;
    }
}
