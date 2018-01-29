package cn.ccut.invoice.usermanagement.dao;

import cn.ccut.invoice.usermanagement.model.UserManagement;
import cn.ccut.invoice.usermanagement.model.UserManagementCustom;

import java.util.List;

/**
 * 扩展类
 */
public interface UserManagementCustomMapper extends UserManagementMapper {
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
    public List<UserManagementCustom> selectUserPage(int start, int pageSize);

    /**
     * 添加用户
     * @param userManagement
     */
    public void addUser(UserManagement userManagement);
}
