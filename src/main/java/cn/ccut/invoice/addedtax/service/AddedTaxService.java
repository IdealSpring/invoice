package cn.ccut.invoice.addedtax.service;

import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;

public interface AddedTaxService {
    /**
     * 查询发票, 计算增值税
     * @param uid
     * @return
     * @throws Exception
     */
    public AddedTaxQueryVo findInvoiceList(Integer uid) throws Exception;
}
