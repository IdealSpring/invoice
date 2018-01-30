package cn.ccut.invoice.systemmanagement.controller;

import cn.ccut.invoice.systemmanagement.model.AdminManagement;
import cn.ccut.invoice.systemmanagement.model.AdminPage;
import cn.ccut.invoice.systemmanagement.service.AdminManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/adminManagement")
public class AdminManagementController {
    @Resource(name = "adminManagementService")
    private AdminManagementService adminManagementService;

    /**
     * 更改权限
     * @param record
     * @return
     */
    @RequestMapping(value = "/editPrem", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String editPrem(AdminManagement record) {
        adminManagementService.updateByPrimaryKey(record);
        return "成功";
    }

    /**
     * 查询用户权限
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/proPermissions")
    public ModelAndView proPermissions(Integer uid) throws Exception{
        AdminManagement adminManagement = adminManagementService.getUserData(uid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("adminManagement", adminManagement);
        modelAndView.setViewName("/jsps/systemmanagement/prempage.jsp");
        return modelAndView;
    }

    /**
     * 查询用户权限列表
     * @param nowPageCode
     * @param model
     * @return
     */
    @RequestMapping(value = "/premList")
    public String premList(String nowPageCode, Model model) {
        int pageCode = 1;
        int pageSize = 10;

        if(nowPageCode != null) {
            pageCode = Integer.parseInt(nowPageCode);
        }

        AdminPage adminPage = adminManagementService.selectAll(pageCode, pageSize);
        model.addAttribute("adminPage", adminPage);

        return "/jsps/systemmanagement/prem.jsp";
    }

    /**
     * 编辑用户信息
     * @param record
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editUser", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String editUser(AdminManagement record) throws Exception{
        adminManagementService.updateByPrimaryKeySelective(record);
        return "修改成功";
    }

    /**
     * 获取用户信息
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/proEditUser")
    public ModelAndView proEditUser(Integer uid) throws Exception{
        AdminManagement adminManagement = adminManagementService.getUserData(uid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jsps/systemmanagement/updateadmin.jsp");
        modelAndView.addObject("adminManagement", adminManagement);
        return modelAndView;
    }

    /**
     * 删除管理员
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delectUser", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String delectUser(Integer uid) throws Exception{
        adminManagementService.delectUser(uid);
        return "删除成功";
    }

    /**
     * 添加用户
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addAdmin" ,produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String addAdmin(AdminManagement adminManagement) throws Exception{
        adminManagementService.addUser(adminManagement);
        return "添加成功";
    }

    /**
     * 分页显示管理员列表
     * @param nowPageCode
     * @param model
     * @return
     */
    @RequestMapping(value = "/adminList")
    public String adminList(String nowPageCode, Model model) {
        int pageCode = 1;
        int pageSize = 10;

        if(nowPageCode != null) {
            pageCode = Integer.parseInt(nowPageCode);
        }

        AdminPage adminPage = adminManagementService.selectAll(pageCode, pageSize);
        model.addAttribute("adminPage", adminPage);

        return "/jsps/systemmanagement/admininformation.jsp";
    }
}
