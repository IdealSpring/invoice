package cn.ccut.invoice.indata.service.impl;

import cn.ccut.invoice.indata.dao.InvoiceMapperCustom;
import cn.ccut.invoice.indata.model.Invoice;
import cn.ccut.invoice.indata.model.InvoiceCustom;
import cn.ccut.invoice.indata.model.PageBean;
import cn.ccut.invoice.indata.service.InvoiceService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务逻辑层实现类
 */
@Component(value = "invoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapperCustom invoiceMapperCustom;

    /**
     * 批量添加数据
     * @param
     * @throws Exception
     */
    public void insertByBatch(Integer uid, InputStream inputStream) throws Exception {
        //获取工作薄
        Workbook workbook = Workbook.getWorkbook(inputStream);
        List<InvoiceCustom> lsit = new ArrayList<InvoiceCustom>();
        InvoiceCustom invoiceCustom = null;

        //获取sheet
        Sheet[] sheets = workbook.getSheets();
        for (int i = 0; i < sheets.length; i++) {
            int rows = sheets[i].getRows();

            if(rows >= 1) {
                for (int j = 1; j < rows ; j++) {
                    invoiceCustom = new InvoiceCustom();
                    Cell[] cells = sheets[i].getRow(j);

                    //设置Number
                    invoiceCustom.setNumber(cells[0].getContents());

                    //设置Name
                    invoiceCustom.setName(cells[1].getContents());

                    //设置Kind
                    if (cells[2].getContents().indexOf("进") > 0) {
                        invoiceCustom.setKind(true);
                    } else {
                        invoiceCustom.setKind(false);
                    }

                    //设置Money
                    invoiceCustom.setMoney(new BigDecimal(cells[3].getContents()));

                    //设置Uid
                    invoiceCustom.setUid(uid);

                    //设置Date
                    invoiceCustom.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(cells[4].getContents()));

                    lsit.add(invoiceCustom);
                }
            }

            invoiceMapperCustom.insertByBatch(lsit);
        }
    }

    /**
     * 添加单条记录
     * @param invoiceCustom
     * @throws Exception
     */
    public void insertOneRecord(InvoiceCustom invoiceCustom) throws Exception{
        invoiceMapperCustom.insertSelective(invoiceCustom);
    }

    /**
     * 查询分分页所有记录
     * @param pageCode
     * @param pageSize
     * @return
     */
    public PageBean selectAll(int uid, int pageCode, int pageSize) {
        PageBean pageBean = new PageBean();
        pageBean.setUid(uid);
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        int total = invoiceMapperCustom.selectAllCount(uid);
        pageBean.setTotalRecord(total);
        List<InvoiceCustom> list = invoiceMapperCustom.selectByLimit(uid, (pageCode-1)*pageSize, pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 删除单条记录
     * @param iid
     * @throws Exception
     */
    public void deleteOneRecord(Integer iid) throws Exception {
        invoiceMapperCustom.delectOneRecord(iid);
    }

    /**
     * 单条查询
     * @param iid
     * @return
     */
    public Invoice selectOneRecord(Integer iid) {
        return invoiceMapperCustom.selectByPrimaryKey(iid);
    }

    /**
     * 修改一条记录
     * @param invoice
     */
    public void updateOneRecord(Invoice invoice) {
        invoiceMapperCustom.updateByPrimaryKeySelective(invoice);
    }

    /**
     * 下载内容
     * @param iid
     * @return
     */
    public List<InvoiceCustom> getBatchRecord(Integer[] iid) {
        return invoiceMapperCustom.selectByBatch(iid);
    }
}
