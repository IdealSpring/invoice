package cn.ccut.invoice.statistics.service.impl;

import cn.ccut.invoice.statistics.dao.InvoiceMapperCustom;
import cn.ccut.invoice.statistics.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口实现类
 */
@Component(value = "InvoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapperCustom invoiceMapperCustom;

}
