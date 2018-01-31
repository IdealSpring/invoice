package cn.ccut.invoice.loginlog.controller;

import cn.ccut.invoice.loginlog.model.LogPage;
import cn.ccut.invoice.loginlog.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/log")
public class LogController {
    @Resource(name = "logService")
    private LogService logService;

    /**
     * 查看日志分页
     * @param nowPageCode
     * @param model
     * @return
     */
    @RequestMapping(value = "/logList")
    public String logList(String nowPageCode, Model model) {
        int pageCode = 1;
        int pageSize = 10;

        if(nowPageCode != null) {
            pageCode = Integer.parseInt(nowPageCode);
        }

        LogPage logPage = logService.getLogList(pageCode, pageSize);
        model.addAttribute("logPage", logPage);

        return "/jsps/loginlog/loginformation.jsp";
    }

    /**
     * 删除日志
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delectLog", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String delectLog(Integer lid) throws Exception{
        logService.delectLog(lid);
        return "删除成功";
    }

    /**
     * 清空日志
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delectAllLog", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String delectAllLog() throws Exception{
        logService.delectAllLog();
        return "删除成功";
    }

}
