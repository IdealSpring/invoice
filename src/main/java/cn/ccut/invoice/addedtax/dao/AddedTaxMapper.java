package cn.ccut.invoice.addedtax.dao;

import cn.ccut.invoice.addedtax.model.AddedTax;

public interface AddedTaxMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(AddedTax record);

    int insertSelective(AddedTax record);

    AddedTax selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(AddedTax record);

    int updateByPrimaryKey(AddedTax record);
}
