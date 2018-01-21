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

    /**
     * 返回对应用户的总记录数
     * @param uid
     * @return
     */
    public int selectAllCount(int uid);

    public List<InvoiceCustom> selectByLimit(int uid, int start, int pageSize);
}
