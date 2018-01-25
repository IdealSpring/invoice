package cn.ccut.invoice.statistics.service;

import cn.ccut.invoice.statistics.model.StatisticsQueryVo;

import java.util.Set;

/**
 * 业务逻辑层接口
 */
public interface StatisticsService {
    /**
     * 查询年份
     * @return
     * @throws Exception
     */
    public Set<String> selectYears(Integer uid) throws Exception;

    /**
     * 查询数据
     * @param uid
     * @param year
     * @return
     */
    public StatisticsQueryVo selectChartData(Integer uid, Integer year);
}
