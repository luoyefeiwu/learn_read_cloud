package com.jerry.bookcloud.account.dao;

import com.jerry.bookcloud.common.pojo.account.UserBookshelf;

public interface UserBookshelfMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    int insert(UserBookshelf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    int insertSelective(UserBookshelf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    UserBookshelf selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserBookshelf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bookshelf
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserBookshelf record);
}