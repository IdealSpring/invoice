package cn.ccut.invoice.usermanagement.service.impl;

import cn.ccut.invoice.usermanagement.dao.UserManagementCustomMapper;
import cn.ccut.invoice.usermanagement.model.UserManagement;
import cn.ccut.invoice.usermanagement.model.UserManagementCustom;
import cn.ccut.invoice.usermanagement.model.UserPage;
import cn.ccut.invoice.usermanagement.service.UsermanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "usermanagementService")
public class UsermanagementServiceImpl implements UsermanagementService {
    @Autowired
    private UserManagementCustomMapper userManagementCustomMapper;

    public void addUser(UserManagement userManagement) throws Exception {
        userManagementCustomMapper.addUser(userManagement);
    }

    /**
     * 分页显示用户信息
     * @param pageCode
     * @param pageSize
     * @return
     */
    public UserPage selectAll(int pageCode, int pageSize) {
        UserPage userPage = new UserPage();
        userPage.setPageCode(pageCode);
        userPage.setPageSize(pageSize);

        int totalRecord = userManagementCustomMapper.selectTotalRecord();
        userPage.setTotalRecord(totalRecord);

        List<UserManagementCustom> list = userManagementCustomMapper.selectUserPage((pageCode - 1)*pageSize, pageSize);
        userPage.setList(list);

        return userPage;
    }

    /**
     * 删除用户
     * @param uid
     */
    public void delectUser(Integer uid) {
        userManagementCustomMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public UserManagement getUserData(Integer uid) {
        return userManagementCustomMapper.selectByPrimaryKey(uid);
    }

    /**
     * 更新用户
     * @param record
     */
    public void updateByPrimaryKeySelective(UserManagement record) {
        userManagementCustomMapper.updateByPrimaryKeySelective(record);
    }
}
