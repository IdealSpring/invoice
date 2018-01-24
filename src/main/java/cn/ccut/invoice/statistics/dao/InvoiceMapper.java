package cn.ccut.invoice.statistics.dao;

import cn.ccut.invoice.statistics.model.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}