package cn.ccut.invoice.systemmanagement.service;

import cn.ccut.invoice.systemmanagement.model.AdminManagement;
import cn.ccut.invoice.systemmanagement.model.AdminPage;

public interface AdminManagementService {
    /**
     * 查询管理员的信息---分页
     * @param pageCode
     * @param pageSize
     * @return
     */
    public AdminPage selectAll(int pageCode, int pageSize);

    /**
     * 添加管理员
     * @param
     */
    public void addUser(AdminManagement adminManagement);

    /**
     * 删除用户
     * @param uid
     */
    public void delectUser(Integer uid);

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public AdminManagement getUserData(Integer uid);

    /**
     * 更新用户
     * @param record
     */
    public void updateByPrimaryKeySelective(AdminManagement record);

    public void updateByPrimaryKey(AdminManagement record);
}
