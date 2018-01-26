package cn.ccut.invoice.query.service;

import cn.ccut.invoice.query.model.PageBean;

public interface QueryService {
    /**
     * 分页显示所有进项数据
     * @param uid
     * @param pagecode
     * @param pageSize
     * @return
     */
    public PageBean getAllInputData(Integer uid, int pagecode, int pageSize);
}
