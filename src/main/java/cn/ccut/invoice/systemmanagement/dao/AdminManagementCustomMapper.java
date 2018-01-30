package cn.ccut.invoice.systemmanagement.dao;

import cn.ccut.invoice.systemmanagement.model.AdminManagement;
import cn.ccut.invoice.systemmanagement.model.AdminManagementCustom;

import java.util.List;

/**
 * 扩展类
 */
public interface AdminManagementCustomMapper extends AdminManagementMapper{

    /**
     * 添加用户
     * @param
     */
    public void addUser(AdminManagement adminManagement);

    /**
     * 获取总记录数
     * @return
     */
    public int selectTotalRecord();

    /**
     * 获取页面数
     * @param start
     * @param pageSize
     * @return
     */
    public List<AdminManagementCustom> selectUserPage(int start, int pageSize);
}