package cn.ccut.invoice.query.service.impl;

import cn.ccut.invoice.query.dao.QueryCustomMapper;
import cn.ccut.invoice.query.model.PageBean;
import cn.ccut.invoice.query.model.QueryCustom;
import cn.ccut.invoice.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "queryService")
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryCustomMapper queryCustomMapper;

    /**
     * 分页显示所有进项数据
     * @param uid
     * @param
     * @param pageSize
     * @return
     */
    public PageBean getAllInputData(Integer uid, int pageCode, int pageSize) {
        PageBean pageBean = new PageBean();
        pageBean.setUid(uid);
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        int total = queryCustomMapper.selectAllCount(uid, true);
        pageBean.setTotalRecord(total);

        List<QueryCustom> list = queryCustomMapper.selectByLimit(uid, (pageCode-1)*pageSize, pageSize, true);
        pageBean.setList(list);
        return pageBean;
    }
}
