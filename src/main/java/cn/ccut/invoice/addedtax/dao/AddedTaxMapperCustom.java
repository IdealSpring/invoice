package cn.ccut.invoice.addedtax.dao;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;

import java.util.List;

public interface AddedTaxMapperCustom {
    /**
     * 发票查询列表
     * @param addedTaxQueryVo
     * @return
     * @throws Exception
     */
    public List<AddedTaxCustom> findInvoiceList(AddedTaxQueryVo addedTaxQueryVo) throws Exception;

    /**
     * 根据月份查询数据条数
     * @param uid
     * @return
     * @throws Exception
     */
    public int findNumberByDate(int uid, String date) throws Exception;

    /**
     * 分页查询月详细数据
     * @param date
     * @param start
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<AddedTaxCustom> findInvoiceListByDate(int uid, String date, int start, int pageSize) throws Exception;
}
