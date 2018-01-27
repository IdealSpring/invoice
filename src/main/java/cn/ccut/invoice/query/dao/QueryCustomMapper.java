package cn.ccut.invoice.query.dao;

import cn.ccut.invoice.query.model.QueryCustom;
import cn.ccut.invoice.query.model.QueryVo;

import java.util.List;

public interface QueryCustomMapper extends QueryMapper{
    /**
     * 查询 进项数据/销项数据总条数
     * @param
     * @return
     */
    public int selectAllCount(QueryVo queryVo);

    /**
     * 查询结果
     * @param
     * @return
     */
    public List<QueryCustom> selectByLimit(QueryVo queryVo);
}