package cn.ccut.invoice.indata.service;

import cn.ccut.invoice.indata.model.Invoice;
import cn.ccut.invoice.indata.model.InvoiceCustom;
import cn.ccut.invoice.indata.model.PageBean;
import sun.org.mozilla.javascript.internal.EcmaError;

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

    /**
     * 查询页面信息
     * @param pageCode
     * @param pageSize
     * @return
     */
    public PageBean selectAll(int uid, int pageCode, int pageSize) throws Exception;

    /**
     * 删除单条记录
     * @param iid
     * @throws Exception
     */
    public void deleteOneRecord(Integer iid) throws Exception;

    /**
     * 单条查询
     * @param iid
     * @return
     */
    public Invoice selectOneRecord(Integer iid);

    /**
     * 修改一条记录
     * @param invoice
     */
    public void updateOneRecord(Invoice invoice);

    /**
     * 下载内容
     * @param iid
     * @return
     */
    public List<InvoiceCustom> getBatchRecord(Integer[] iid);
}






