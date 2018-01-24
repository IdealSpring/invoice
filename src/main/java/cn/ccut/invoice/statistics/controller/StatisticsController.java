package cn.ccut.invoice.statistics.controller;

import cn.ccut.invoice.statistics.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource(name = "statisticsServiceImpl")
    private StatisticsService statisticsService;
}
