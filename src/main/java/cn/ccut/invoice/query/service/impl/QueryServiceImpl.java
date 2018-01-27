package cn.ccut.invoice.query.service.impl;

import cn.ccut.invoice.query.dao.QueryCustomMapper;
import cn.ccut.invoice.query.model.PageBean;
import cn.ccut.invoice.query.model.QueryCustom;
import cn.ccut.invoice.query.model.QueryVo;
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
     * @param
     * @return
     */
    public PageBean getAllInputData(QueryVo queryVo) {
        queryVo.setKind(true);

        queryVo.setStartIndex((queryVo.getPageCode() - 1)*queryVo.getPageSize());
        PageBean pageBean = new PageBean();
        pageBean.setUid(queryVo.getUid());
        pageBean.setPageCode(queryVo.getPageCode());
        pageBean.setPageSize(queryVo.getPageSize());

        int total = queryCustomMapper.selectAllCount(queryVo);
        pageBean.setTotalRecord(total);

        //List<QueryCustom> list = queryCustomMapper.selectByLimit(uid, (pageCode-1)*pageSize, pageSize, true);
        List<QueryCustom> list = queryCustomMapper.selectByLimit(queryVo);
        pageBean.setList(list);
        return pageBean;
    }

    public PageBean getAllOutputData(QueryVo queryVo) {
        queryVo.setKind(false);

        queryVo.setStartIndex((queryVo.getPageCode() - 1)*queryVo.getPageSize());
        PageBean pageBean = new PageBean();
        pageBean.setUid(queryVo.getUid());
        pageBean.setPageCode(queryVo.getPageCode());
        pageBean.setPageSize(queryVo.getPageSize());

        int total = queryCustomMapper.selectAllCount(queryVo);
        pageBean.setTotalRecord(total);

        //List<QueryCustom> list = queryCustomMapper.selectByLimit(uid, (pageCode-1)*pageSize, pageSize, true);
        List<QueryCustom> list = queryCustomMapper.selectByLimit(queryVo);
        pageBean.setList(list);
        return pageBean;
    }
}
