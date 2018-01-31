package cn.ccut.invoice.loginlog.service.impl;

import cn.ccut.invoice.loginlog.dao.LogCustomMapper;
import cn.ccut.invoice.loginlog.model.Log;
import cn.ccut.invoice.loginlog.model.LogCustom;
import cn.ccut.invoice.loginlog.model.LogPage;
import cn.ccut.invoice.loginlog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*必须这样注入，否者出错*/
/*@Component(value = "logService")*/
public class LogServiceImpl implements LogService {
    @Autowired
    private LogCustomMapper logCustomMapper;

    /**
     * 添加记录
     * @param log
     */
    public void addLog(Log log) {
        logCustomMapper.addUserLog(log);
    }

    /**
     * 添加用户登出时间
     *
     * @param record
     */
    public void addLogLogout(Log record) {
        logCustomMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 分页显示登录日志
     *
     * @param pageCode
     * @param pageSize
     * @return
     */
    public LogPage getLogList(int pageCode, int pageSize) {
        LogPage logPage = new LogPage();
        logPage.setPageCode(pageCode);
        logPage.setPageSize(pageSize);

        int totalRecord = logCustomMapper.selectCount();
        logPage.setTotalRecord(totalRecord);

        List<LogCustom> list = logCustomMapper.selectLogPage((pageCode - 1)*pageSize, pageSize);
        logPage.setList(list);

        return logPage;
    }

    /**
     * 根据lid删除日志
     *
     * @param lid
     */
    public void delectLog(Integer lid) {
        logCustomMapper.deleteByPrimaryKey(lid);
    }

    /**
     * 删除所有日志
     */
    public void delectAllLog() {
        logCustomMapper.delectAllLog();
    }
}




