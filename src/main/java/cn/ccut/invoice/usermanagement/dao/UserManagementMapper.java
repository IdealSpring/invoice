package cn.ccut.invoice.usermanagement.dao;

import cn.ccut.invoice.usermanagement.model.UserManagement;

public interface UserManagementMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserManagement record);

    int insertSelective(UserManagement record);

    UserManagement selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserManagement record);

    int updateByPrimaryKey(UserManagement record);
}