package cn.ccut.invoice.query.service;

import cn.ccut.invoice.query.model.PageBean;
import cn.ccut.invoice.query.model.QueryVo;

public interface QueryService {
    /**
     * 分页显示所有进项数据
     * @param
     * @return
     */
    public PageBean getAllInputData(QueryVo queryVo);
    /**
     * 分页显示所有进项数据
     * @param
     * @return
     */
    public PageBean getAllOutputData(QueryVo queryVo);
}
