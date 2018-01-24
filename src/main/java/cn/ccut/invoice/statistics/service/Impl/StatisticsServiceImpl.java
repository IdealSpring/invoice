package cn.ccut.invoice.statistics.service.Impl;

import cn.ccut.invoice.statistics.dao.StatisticsMapperCustom;
import cn.ccut.invoice.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 业务逻辑层实现类
 */
@Component(value = "statisticsServiceImpl")
public class StatisticsServiceImpl implements StatisticsService{
    @Autowired
    private StatisticsMapperCustom statisticsMapperCustom;
}
