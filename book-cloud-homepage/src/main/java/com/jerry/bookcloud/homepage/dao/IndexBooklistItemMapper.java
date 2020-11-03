package com.jerry.bookcloud.homepage.dao;

import com.jerry.bookcloud.common.pojo.index.IndexBooklistItem;

public interface IndexBooklistItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    int insert(IndexBooklistItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    int insertSelective(IndexBooklistItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    IndexBooklistItem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(IndexBooklistItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table index_booklist_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(IndexBooklistItem record);
}