package cn.ccut.invoice.statistics.controller;

import cn.ccut.invoice.statistics.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * statistics控制
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource(name = "InvoiceServiceImpl")
    private InvoiceService invoiceService;


}
