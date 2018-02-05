package cn.ccut.invoice.addedtax.service.impl;

import cn.ccut.invoice.addedtax.dao.AddedTaxMapperCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.service.AddedTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @authorMr.Robot
 * @create2018-02-05 20:51
 */
@Component(value = "addedTaxServiceImpl")
public class AddedTaxServiceImpl implements AddedTaxService {
    @Autowired
    private AddedTaxMapperCustom addedTaxMapperCustom;

    /**
     * 查询发票, 计算增值税
     * @param uid
     * @return
     * @throws Exception
     */
    public AddedTaxQueryVo findInvoiceList(Integer uid) throws Exception {
        return null;
    }
}
