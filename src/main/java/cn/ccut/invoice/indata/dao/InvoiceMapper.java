package cn.ccut.invoice.indata.dao;

import cn.ccut.invoice.indata.model.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}