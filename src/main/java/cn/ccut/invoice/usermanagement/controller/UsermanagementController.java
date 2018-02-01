package cn.ccut.invoice.usermanagement.controller;

import cn.ccut.invoice.usermanagement.model.UserManagement;
import cn.ccut.invoice.usermanagement.model.UserPage;
import cn.ccut.invoice.usermanagement.service.UsermanagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/usermanagement")
public class UsermanagementController {
    @Resource(name = "usermanagementService")
    private UsermanagementService usermanagementService;

    /**
     * 更改用户
     *
     * @param record
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editUser", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String editUser(UserManagement record) throws Exception{
        usermanagementService.updateByPrimaryKeySelective(record);
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
        UserManagement userManagement = usermanagementService.getUserData(uid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jsps/usermanagement/updateuser.jsp");
        modelAndView.addObject("userManagement", userManagement);
        return modelAndView;
    }

    /**
     * 删除用户
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delectUser", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String delectUser(Integer uid) throws Exception{
        usermanagementService.delectUser(uid);
        return "删除成功";
    }

    /**
     * 添加用户
     * @param userManagement
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addUser" ,produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String addUser(UserManagement userManagement) throws Exception{
       usermanagementService.addUser(userManagement);
        return "添加成功";
    }

    /**
     * 分页显示用户列表
     * @param nowPageCode
     * @param model
     * @return
     */
    @RequestMapping(value = "/userList")
    public String userList(String nowPageCode, Model model) {
        int pageCode = 1;
        int pageSize = 10;

        if(nowPageCode != null) {
            pageCode = Integer.parseInt(nowPageCode);
        }

        UserPage userPage = usermanagementService.selectAll(pageCode, pageSize);
        model.addAttribute("userPage", userPage);

        return "/jsps/usermanagement/userinformation.jsp";
    }

}
