package cn.ccut.invoice.indata.controller;

import cn.ccut.invoice.indata.model.InvoiceCustom;
import cn.ccut.invoice.indata.service.InvoiceService;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.*;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExcelUtils {

    /**
     * 创建下载内容
     * @return
     * @throws Exception
     */
    public static WritableWorkbook creatExcelData(OutputStream outputStream, Integer[] iid, InvoiceService invoiceService) throws Exception{
        //创建Excel
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);

        //创建第一页
        WritableSheet sheet = writableWorkbook.createSheet("进销项数据", 0);

        //设置格式
        for(int i = 0; i < 5; i++) {
            sheet.setColumnView(i, 20);
        }

        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 14, WritableFont.BOLD);

        WritableCellFormat writableCellFormat = new WritableCellFormat(font);
        //设置居中
        writableCellFormat.setAlignment(Alignment.CENTRE);
        // 设置边框线
        //writableCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

        Label label1 = new Label(0, 0, "发票编号", writableCellFormat);
        Label label2 = new Label(1, 0, "发票名称", writableCellFormat);
        Label label3 = new Label(2, 0, "种类", writableCellFormat);
        Label label4 = new Label(3, 0, "金额", writableCellFormat);
        Label label5 = new Label(4, 0, "发票时间", writableCellFormat);

        sheet.addCell(label1);
        sheet.addCell(label2);
        sheet.addCell(label3);
        sheet.addCell(label4);
        sheet.addCell(label5);

        List<InvoiceCustom> list = invoiceService.getBatchRecord(iid);

        int i = 1;
        for(InvoiceCustom invoiceCustom : list) {
            Label la1 = new Label(0, i, invoiceCustom.getNumber());
            Label la2 = new Label(1, i, invoiceCustom.getName());

            Label la3 = null;
            if(invoiceCustom.getKind()) {
                la3 = new Label(2, i, "进项数据");
            } else {
                la3 = new Label(2, i, "销项数据");
            }

            Label la4 = new Label(3, i, invoiceCustom.getMoney().toString());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/HH/dd");
            Label la5 = new Label(4, i, dateFormat.format(invoiceCustom.getDate()));
            i++;

            sheet.addCell(la1);
            sheet.addCell(la2);
            sheet.addCell(la3);
            sheet.addCell(la4);
            sheet.addCell(la5);
        }
        return writableWorkbook;
    }
    /**
     * 模板
     * @param outputStream
     * @return
     * @throws Exception
     */
    public static WritableWorkbook createTemplate(OutputStream outputStream) throws Exception {
        //创建Excel
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);

        //创建第一页
        WritableSheet sheet = writableWorkbook.createSheet("数据导入模板", 0);

        //设置格式
        for(int i = 0; i < 5; i++) {
            sheet.setColumnView(i, 20);
        }
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 14, WritableFont.BOLD);

        WritableCellFormat writableCellFormat = new WritableCellFormat(font);
        //设置居中
        writableCellFormat.setAlignment(Alignment.CENTRE);
        // 设置边框线
        //writableCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

        Label label1 = new Label(0, 0, "发票编号", writableCellFormat);
        Label label2 = new Label(1, 0, "发票名称", writableCellFormat);
        Label label3 = new Label(2, 0, "种类", writableCellFormat);
        Label label4 = new Label(3, 0, "金额", writableCellFormat);
        Label label5 = new Label(4, 0, "发票时间", writableCellFormat);

        sheet.addCell(label1);
        sheet.addCell(label2);
        sheet.addCell(label3);
        sheet.addCell(label4);
        sheet.addCell(label5);

        return writableWorkbook;
    }
}
