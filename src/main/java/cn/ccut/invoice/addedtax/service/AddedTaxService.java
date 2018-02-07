package cn.ccut.invoice.addedtax.service;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.model.PageBean;

import java.util.List;

public interface AddedTaxService {
    /**
     * 查询发票, 计算增值税
     * @param addedTaxQueryVo
     * @return
     * @throws Exception
     */
    public List<AddedTaxCustom> findInvoiceList(AddedTaxQueryVo addedTaxQueryVo) throws Exception;

    /**
     * 根据月份,分页显示详情
     * @param date
     * @param pageCode
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean selectByDate(int uid, String date, int pageCode, int pageSize) throws  Exception;
}
