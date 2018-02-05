package cn.ccut.invoice.addedtax.model;

import java.util.List;

/**
 * @authorMr.Robot
 * @create2018-02-05 13:28
 */
public class AddedTaxQueryVo {
    // 发票信息
    private AddedTax addedTax;

    // 对原始po进行扩展
    private AddedTaxCustom addedTaxCustom;

    // 批量发票信息
    private List<AddedTaxCustom> addedTaxList;

    public AddedTax getAddedTax() {
        return addedTax;
    }

    public void setAddedTax(AddedTax addedTax) {
        this.addedTax = addedTax;
    }

    public AddedTaxCustom getAddedTaxCustom() {
        return addedTaxCustom;
    }

    public void setAddedTaxCustom(AddedTaxCustom addedTaxCustom) {
        this.addedTaxCustom = addedTaxCustom;
    }

    public List<AddedTaxCustom> getAddedTaxList() {
        return addedTaxList;
    }

    public void setAddedTaxList(List<AddedTaxCustom> addedTaxList) {
        this.addedTaxList = addedTaxList;
    }
}
