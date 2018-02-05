package cn.ccut.invoice.addedtax.dao;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;

import java.util.List;

public interface AddedTaxMapperCustom {
    // 发票查询列表
    public List<AddedTaxCustom> findInvoiceList(AddedTaxQueryVo addedTaxQueryVo) throws Exception;
}
