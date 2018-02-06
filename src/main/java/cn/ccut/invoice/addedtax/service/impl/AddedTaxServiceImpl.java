package cn.ccut.invoice.addedtax.service.impl;

import cn.ccut.invoice.addedtax.dao.AddedTaxMapperCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.service.AddedTaxService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @authorMr.Robot
 * @create2018-02-05 20:51
 */
public class AddedTaxServiceImpl implements AddedTaxService {
    @Autowired
    private AddedTaxMapperCustom addedTaxMapperCustom;

    /**
     * 查询发票, 计算增值税
     * @param addedTaxQueryVo
     * @return
     * @throws Exception
     */
    public List<AddedTaxCustom> findInvoiceList(AddedTaxQueryVo addedTaxQueryVo) throws Exception {
        System.out.println("service------------------------------");
        return addedTaxMapperCustom.findInvoiceList(addedTaxQueryVo);

       // return null;
    }
}
