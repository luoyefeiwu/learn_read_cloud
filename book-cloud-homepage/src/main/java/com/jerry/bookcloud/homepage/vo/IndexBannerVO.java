package com.jerry.bookcloud.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Banner VO
 * @author: zealon
 * @since: 2020/4/6
 */
@NoArgsConstructor
@AllArgsConstructor
public class IndexBannerVO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private List<BannerItemVO> items;

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

    public List<BannerItemVO> getItems() {
        return items;
    }

    public void setItems(List<BannerItemVO> items) {
        this.items = items;
    }
}
