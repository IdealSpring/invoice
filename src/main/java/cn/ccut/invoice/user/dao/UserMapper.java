package cn.ccut.invoice.user.dao;

import cn.ccut.invoice.user.model.User;

/**
 * 2018年1月16日10:56:54
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}