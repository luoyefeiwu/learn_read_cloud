package com.jerry.bookcloud.account.dao;

import com.jerry.bookcloud.common.pojo.account.UserLikeSee;

public interface UserLikeSeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    int insert(UserLikeSee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    int insertSelective(UserLikeSee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    UserLikeSee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserLikeSee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_like_see
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserLikeSee record);
}