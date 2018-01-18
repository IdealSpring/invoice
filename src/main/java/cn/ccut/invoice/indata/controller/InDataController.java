package cn.ccut.invoice.indata.controller;

import jxl.write.WritableWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/indata")
public class InDataController {

    /**
     * Excel模板
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/templateDownload")
    public void templateDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //一流两头
        //设置相应头,在浏览器客户端弹框
        String filename = new String("模板.xls".getBytes("GBK"), "ISO-8859-1");
        String contextDisposition = "attachment; filename=" + filename;
        response.setHeader("Content-Disposition", contextDisposition);

        WritableWorkbook writableWorkbook = ExcelUtils.createTemplate(response.getOutputStream());
        writableWorkbook.write();
        writableWorkbook.close();
    }
}
