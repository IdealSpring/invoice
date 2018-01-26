package cn.ccut.invoice.query.dao;

import cn.ccut.invoice.query.model.QueryCustom;

import java.util.List;

public interface QueryCustomMapper extends QueryMapper{
    /**
     * 查询 进项数据/销项数据总条数
     * @param uid
     * @param kind
     * @return
     */
    public int selectAllCount(Integer uid, boolean kind);

    /**
     * 查询结果
     * @param uid
     * @param startIndex
     * @param number
     * @param kind
     * @return
     */
    public List<QueryCustom> selectByLimit(Integer uid, int startIndex, int number, boolean kind);
}