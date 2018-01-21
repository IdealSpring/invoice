package cn.ccut.invoice.indata.service;

import cn.ccut.invoice.indata.model.InvoiceCustom;

import java.io.InputStream;
import java.util.List;

/**
 * 发票数据抽象类
 */
public interface InvoiceService {
    /**
     * 批量添加数据
     * @param list
     * @throws Exception
     */
    public void insertByBatch(Integer uid, InputStream inputStream) throws Exception;

    /**
     * 添加单条记录
     * @param invoiceCustom
     * @throws Exception
     */
    public void insertOneRecord(InvoiceCustom invoiceCustom) throws Exception;
}






