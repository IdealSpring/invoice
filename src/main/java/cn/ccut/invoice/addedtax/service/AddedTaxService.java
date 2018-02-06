package cn.ccut.invoice.addedtax.service;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;

import java.util.List;

public interface AddedTaxService {
    /**
     * 查询发票, 计算增值税
     * @param addedTaxQueryVo
     * @return
     * @throws Exception
     */
    public List<AddedTaxCustom> findInvoiceList(AddedTaxQueryVo addedTaxQueryVo) throws Exception;
}
