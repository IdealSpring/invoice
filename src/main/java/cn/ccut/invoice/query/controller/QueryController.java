package cn.ccut.invoice.query.controller;

import cn.ccut.invoice.query.model.PageBean;
import cn.ccut.invoice.query.service.QueryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/query")
public class QueryController {
    @Resource(name = "queryService")
    private QueryService queryService;

    /**
     * 分页显示所有进项数据
     * @param pageCode
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryAllinputData")
    @ResponseBody
    public PageBean queryAllnputData(String pageCode, HttpServletRequest request) {
        System.out.println(pageCode);
        //获取用户roleID
        //String roleID = (String) request.getSession().getAttribute("roleID");
        Integer uid = 10;
        int pagecode = 1;
        int pageSize = 10;

        if(pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        PageBean pageBean = queryService.getAllInputData(uid, pagecode, pageSize);
        return pageBean;
    }
}








