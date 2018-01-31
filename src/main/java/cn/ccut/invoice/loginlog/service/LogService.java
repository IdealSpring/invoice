package cn.ccut.invoice.loginlog.service;

import cn.ccut.invoice.loginlog.model.Log;
import cn.ccut.invoice.loginlog.model.LogPage;

public interface LogService {

    /**
     * 添加记录
     * @param log
     */
    void addLog(Log log);

    /**
     * 添加用户登出时间
     * @param record
     */
    void addLogLogout(Log record);

    /**
     * 分页显示登录日志
     *
     * @param pageCode
     * @param pageSize
     * @return
     */
    LogPage getLogList(int pageCode, int pageSize);

    /**
     * 根据lid删除日志
     *
     * @param lid
     */
    void delectLog(Integer lid);

    /**
     * 删除所有日志
     */
    void delectAllLog();
}
