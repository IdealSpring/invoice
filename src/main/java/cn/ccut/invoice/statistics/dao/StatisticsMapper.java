package cn.ccut.invoice.statistics.dao;

import cn.ccut.invoice.statistics.model.Statistics;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}