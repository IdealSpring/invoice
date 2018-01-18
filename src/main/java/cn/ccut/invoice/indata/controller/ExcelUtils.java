package cn.ccut.invoice.indata.controller;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.*;

import java.io.OutputStream;

public class ExcelUtils {
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
