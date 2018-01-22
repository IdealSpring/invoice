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

    /**
     * 分页的查询
     * @param uid
     * @param start
     * @param pageSize
     * @return
     */
    public List<InvoiceCustom> selectByLimit(int uid, int start, int pageSize);

    /**
     * 删除单条记录
     * @param iid
     */
    public void delectOneRecord(Integer iid);

    /**
     * 批量导出
     * @param iid
     * @return
     */
    public List<InvoiceCustom> selectByBatch(Integer[] iid);
}
