package cn.ccut.invoice.loginlog.dao;

import cn.ccut.invoice.loginlog.model.Log;
import cn.ccut.invoice.loginlog.model.LogCustom;

import java.util.List;

public interface LogCustomMapper extends LogMapper{
    /**
     * 添加User记录，并返回id
     * @param record
     */
    void addUserLog(Log record);

    /**
     * 查询总记录数
     *
     * @return
     */
    int selectCount();

    /**
     * 获取每页数据
     *
     * @param i
     * @param pageSize
     * @return
     */
    List<LogCustom> selectLogPage(int i, int pageSize);

    /**
     * 删除所有日志
     */
    void delectAllLog();
}