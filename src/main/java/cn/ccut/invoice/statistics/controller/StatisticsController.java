package cn.ccut.invoice.statistics.controller;

import cn.ccut.invoice.statistics.model.StatisticsQueryVo;
import cn.ccut.invoice.statistics.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource(name = "statisticsServiceImpl")
    private StatisticsService statisticsService;

    /**
     * 生成折线图
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/onloadLineChart")
    @ResponseBody
    public StatisticsQueryVo onloadLineChart(Integer year,HttpServletRequest request) throws Exception {
        //从session中获取用户ID
        //Integer uid = (Integer)request.getSession().getAttribute("roleID");

        Integer uid = 10;
        Set<String> years = statisticsService.selectYears(uid);

        TreeSet<String> yearsTree = (TreeSet<String>) years;
        String yearValue = yearsTree.first().toString().trim();
        Integer y = new Integer(yearValue);
        if(year != null) {
            y = year;
        }

        StatisticsQueryVo queryVo = statisticsService.selectChartData(uid,y);
        queryVo.setYears(years);
        queryVo.setYear(y.toString());
        System.out.println(y);
        System.out.println(Arrays.toString(queryVo.getInputDate()));
        System.out.println(Arrays.toString(queryVo.getOutputDate()));

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("queryVo", queryVo);
        modelAndView.setViewName("/jsps/statistics/line_charts.jsp");*/
        return queryVo;
    }
}



