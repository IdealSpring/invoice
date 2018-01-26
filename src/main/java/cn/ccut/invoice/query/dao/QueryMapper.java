package cn.ccut.invoice.query.dao;

import cn.ccut.invoice.query.model.Query;

public interface QueryMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Query record);

    int insertSelective(Query record);

    Query selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Query record);

    int updateByPrimaryKey(Query record);
}