package cn.ccut.invoice.loginlog.dao;

import cn.ccut.invoice.loginlog.model.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}