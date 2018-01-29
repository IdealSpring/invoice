package cn.ccut.invoice.query.controller;

import cn.ccut.invoice.query.model.PageBean;
import cn.ccut.invoice.query.model.QueryVo;
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
     * 分页显示所有销项数据
     * @param pageCode
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryAllOutputData")
    @ResponseBody
    public PageBean queryAllOutputData(String pageCode, String startDate, String endDate, String query, HttpServletRequest request) {
       //获取用户roleID
        Integer uid = (Integer) request.getSession().getAttribute("roleID");
        int pagecode = 1;
        int pageSize = 10;

        if(pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        QueryVo queryVo = new QueryVo();
        queryVo.setUid(uid);
        queryVo.setPageCode(pagecode);
        queryVo.setPageSize(pageSize);
        queryVo.setStartDate(startDate);
        queryVo.setEndDate(endDate);
        queryVo.setQuery(query);


        PageBean pageBean = queryService.getAllOutputData(queryVo);
        return pageBean;
    }

    /**
     * 分页显示所有进项数据
     * @param pageCode
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryAllinputData")
    @ResponseBody
    public PageBean queryAllnputData(String pageCode, String startDate, String endDate, String query, HttpServletRequest request) {
        //获取用户roleID
        Integer uid = (Integer) request.getSession().getAttribute("roleID");
        int pagecode = 1;
        int pageSize = 10;

        if(pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        QueryVo queryVo = new QueryVo();
        queryVo.setUid(uid);
        queryVo.setPageCode(pagecode);
        queryVo.setPageSize(pageSize);
        queryVo.setStartDate(startDate);
        queryVo.setEndDate(endDate);
        queryVo.setQuery(query);


        PageBean pageBean = queryService.getAllInputData(queryVo);
        return pageBean;
    }
}








