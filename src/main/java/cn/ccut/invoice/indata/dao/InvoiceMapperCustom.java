package cn.ccut.invoice.indata.dao;

import cn.ccut.invoice.indata.model.InvoiceCustom;

import java.util.List;

/**
 * InvoiceMapper的扩展Mapper
 */
public interface InvoiceMapperCustom extends InvoiceMapper {
    /**
     * 批量添加数据
     * @param list
     */
    public void insertByBatch(List<InvoiceCustom> list);
}
