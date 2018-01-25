package cn.ccut.invoice.statistics.service.Impl;

import cn.ccut.invoice.statistics.dao.StatisticsMapperCustom;
import cn.ccut.invoice.statistics.model.StatisticsCustom;
import cn.ccut.invoice.statistics.model.StatisticsQueryVo;
import cn.ccut.invoice.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 业务逻辑层实现类
 */
@Component(value = "statisticsServiceImpl")
public class StatisticsServiceImpl implements StatisticsService{
    @Autowired
    private StatisticsMapperCustom statisticsMapperCustom;

    /**
     * 查询用户记录年份
     * @param uid
     * @return
     * @throws Exception
     */
    public Set<String> selectYears(Integer uid) throws Exception {
        Date[] dates = statisticsMapperCustom.selectYears(uid);

        Set<String> years =new TreeSet<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        for(Date date : dates) {
            years.add(date.toString().substring(date.toString().lastIndexOf(" ") + 1));
        }

        return years;
    }

    /**
     * 查询数据
     * @param uid
     * @param year
     * @return
     */
    public StatisticsQueryVo selectChartData(Integer uid, Integer year) {
        StatisticsQueryVo queryVo = new StatisticsQueryVo();
        int[][] result = new int[2][12];
        //初始化数组
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 12; j++) {
                result[i][j] = 0;
            }
        }

        //进项数据处理
        List<StatisticsCustom> inputList =  statisticsMapperCustom.selectChartsDate(uid,year ,true);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(StatisticsCustom StatisticsCustom : inputList) {
            String date = simpleDateFormat.format(StatisticsCustom.getDate());

            String mouth = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
            int parseInt = Integer.parseInt(mouth);

            for (int i = 1; i <= 12; i++) {
                if(parseInt == i)
                    result[0][i - 1] += StatisticsCustom.getMoney().intValue();
            }
        }

        //销项数据处理
        List<StatisticsCustom> outputList =  statisticsMapperCustom.selectChartsDate(uid,year ,false);
        for(StatisticsCustom StatisticsCustom : outputList) {
            String date = simpleDateFormat.format(StatisticsCustom.getDate());

            String mouth = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
            int parseInt = Integer.parseInt(mouth);

            for (int i = 1; i <= 12; i++) {
                if(parseInt == i)
                    result[1][i - 1] += StatisticsCustom.getMoney().intValue();
            }
        }

        queryVo.setInputDate(result[0]);
        queryVo.setOutputDate(result[1]);
        return queryVo;
    }
}
