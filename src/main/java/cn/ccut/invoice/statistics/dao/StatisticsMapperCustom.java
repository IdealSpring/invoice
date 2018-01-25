package cn.ccut.invoice.statistics.dao;

import cn.ccut.invoice.statistics.model.StatisticsCustom;

import java.util.Date;
import java.util.List;

/**
 * Mapper扩展类
 */
public interface StatisticsMapperCustom {

    /**
     * 查询用户年份
     * @param uid
     * @return
     */
    public Date[] selectYears(Integer uid);

    /**
     * 查询统计表数据
     * @param year
     * @param kind
     * @param uid
     * @return
     */
    public List<StatisticsCustom> selectChartsDate(Integer uid, Integer year, boolean kind);
}