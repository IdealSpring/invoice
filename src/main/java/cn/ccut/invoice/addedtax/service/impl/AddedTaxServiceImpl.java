package cn.ccut.invoice.addedtax.service.impl;

import cn.ccut.invoice.addedtax.dao.AddedTaxMapperCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.model.PageBean;
import cn.ccut.invoice.addedtax.service.AddedTaxService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        List<AddedTaxCustom> addedTaxCustomsList = addedTaxMapperCustom.findInvoiceList(addedTaxQueryVo);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

        for (int i = 0; i < addedTaxCustomsList.size(); i++) {
            int kind = addedTaxCustomsList.get(i).getKind();

            if(kind == 1){
                for (int j = i + 1; j < addedTaxCustomsList.size() &&
                        dateFormat.format(addedTaxCustomsList.get(i).getDate()).equals(dateFormat.format(addedTaxCustomsList.get(j).getDate())); j++) {
                    if (addedTaxCustomsList.get(i).getKind() == 1){
                        addedTaxCustomsList.get(i).setMoney((addedTaxCustomsList.get(i).getMoney()).add( addedTaxCustomsList.get(j).getMoney()));
                        addedTaxCustomsList.remove(j);
                        j--;
                    }
                }
                for (int j = i + 1; j < addedTaxCustomsList.size() &&
                        dateFormat.format(addedTaxCustomsList.get(i).getDate()).equals(dateFormat.format(addedTaxCustomsList.get(j).getDate())); j++) {
                    if (addedTaxCustomsList.get(i).getKind() == 0) {
                        if (addedTaxCustomsList.get(i).getMoney().compareTo(BigDecimal.ZERO) == 1) {
                            addedTaxCustomsList.get(i).setMoney((addedTaxCustomsList.get(j).getMoney()).subtract(addedTaxCustomsList.get(j).getMoney()));
                        } else {
                            addedTaxCustomsList.get(i).setMoney((addedTaxCustomsList.get(j).getMoney()).add( addedTaxCustomsList.get(i).getMoney()));
                        }
                        addedTaxCustomsList.remove(j);
                        j--;
                    }
                }
            }

            if (kind == 0) {
                for (int j = i + 1; j < addedTaxCustomsList.size() &&
                        dateFormat.format(addedTaxCustomsList.get(i).getDate()).equals(dateFormat.format(addedTaxCustomsList.get(j).getDate())); j++) {
                    if (addedTaxCustomsList.get(i).getKind() == 0){
                        addedTaxCustomsList.get(i).setMoney((addedTaxCustomsList.get(i).getMoney()).add( addedTaxCustomsList.get(j).getMoney()));
                        addedTaxCustomsList.remove(j);
                        j--;
                    }
                }
                for (int j = i + 1; j < addedTaxCustomsList.size() &&
                        dateFormat.format(addedTaxCustomsList.get(i).getDate()).equals(dateFormat.format(addedTaxCustomsList.get(j).getDate())); j++) {
                    if (addedTaxCustomsList.get(i).getKind() == 1) {
                        addedTaxCustomsList.get(i).setMoney((addedTaxCustomsList.get(i).getMoney()).subtract(addedTaxCustomsList.get(j).getMoney()));
                        addedTaxCustomsList.remove(j);
                        j--;
                    }
                }
            }
            double a = 0.17;
            BigDecimal aa = new BigDecimal(a);
            addedTaxCustomsList.get(i).setMoney(addedTaxCustomsList.get(i).getMoney().multiply(aa).setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        return addedTaxCustomsList;
    }

    /**
     * 根据月份,分页显示详情
     * @param date
     * @param pageCode
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean selectByDate(int uid, String date, int pageCode, int pageSize) throws Exception {
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date d =  dateFormat.parse(date);
        date = dateFormat.format(d);*/

        PageBean pageBean = new PageBean();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        date += "%";
        int tp = addedTaxMapperCustom.findNumberByDate(uid, date);
        pageBean.setTotalRecord(tp);
        List<AddedTaxCustom> list = addedTaxMapperCustom.findInvoiceListByDate(uid, date,(pageCode-1)*pageSize, pageSize);
        pageBean.setList(list);

        return pageBean;
    }
}
