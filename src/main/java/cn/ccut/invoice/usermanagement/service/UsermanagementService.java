package cn.ccut.invoice.usermanagement.service;

import cn.ccut.invoice.usermanagement.model.UserManagement;
import cn.ccut.invoice.usermanagement.model.UserPage;

/**
 * 业务逻辑层接口
 */
public interface UsermanagementService {
    /**
     * 添加用户
     * @param userManagement
     * @throws Exception
     */
    public void addUser(UserManagement userManagement) throws Exception;

    /**
     * 查询用户的信息---分页
     * @param pageCode
     * @param pageSize
     * @return
     */
    public UserPage selectAll(int pageCode, int pageSize);

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
    public UserManagement getUserData(Integer uid);

    /**
     * 更新用户
     * @param record
     */
    public void updateByPrimaryKeySelective(UserManagement record);
}
