package cn.ccut.invoice.systemmanagement.service.imple;

import cn.ccut.invoice.systemmanagement.dao.AdminManagementCustomMapper;
import cn.ccut.invoice.systemmanagement.model.AdminManagement;
import cn.ccut.invoice.systemmanagement.model.AdminManagementCustom;
import cn.ccut.invoice.systemmanagement.model.AdminPage;
import cn.ccut.invoice.systemmanagement.service.AdminManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "adminManagementService")
public class AdminManagementServiceImpl implements AdminManagementService {
    @Autowired
    private AdminManagementCustomMapper adminManagementCustomMapper;

    /**
     * 更新用户
     * @param record
     */
    public void updateByPrimaryKeySelective(AdminManagement record) {
        adminManagementCustomMapper.updateByPrimaryKeySelective(record);
    }

    public void updateByPrimaryKey(AdminManagement record) {
        adminManagementCustomMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public AdminManagement getUserData(Integer uid) {
        return adminManagementCustomMapper.selectByPrimaryKey(uid);
    }

    /**
     * 删除用户
     * @param uid
     */
    public void delectUser(Integer uid) {
        adminManagementCustomMapper.deleteByPrimaryKey(uid);
    }

    public void addUser(AdminManagement adminManagement) {
        adminManagementCustomMapper.addUser(adminManagement);
    }

    public AdminPage selectAll(int pageCode, int pageSize) {
        AdminPage adminPage = new AdminPage();
        adminPage.setPageCode(pageCode);
        adminPage.setPageSize(pageSize);

        int totalRecord = adminManagementCustomMapper.selectTotalRecord();
        adminPage.setTotalRecord(totalRecord);

        List<AdminManagementCustom> list = adminManagementCustomMapper.selectUserPage((pageCode - 1)*pageSize, pageSize);
        adminPage.setList(list);

        return adminPage;
    }
}
