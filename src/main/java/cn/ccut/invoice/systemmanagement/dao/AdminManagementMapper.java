package cn.ccut.invoice.systemmanagement.dao;

import cn.ccut.invoice.systemmanagement.model.AdminManagement;

public interface AdminManagementMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(AdminManagement record);

    int insertSelective(AdminManagement record);

    AdminManagement selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(AdminManagement record);

    int updateByPrimaryKey(AdminManagement record);
}