package cn.ccut.invoice.indata.controller;

import cn.ccut.invoice.indata.model.InvoiceCustom;
import cn.ccut.invoice.indata.model.PageBean;
import cn.ccut.invoice.indata.service.InvoiceService;
import jxl.write.WritableWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Controller
@RequestMapping("/indata")
public class InvoiceController {
    @Resource(name = "invoiceServiceImpl")
    private InvoiceService invoiceServiceImpl;

    /**
     * 分页数据
     * @return
     */
    @RequestMapping("/pageRecord")
    public ModelAndView pageRecord(String pageCode, HttpServletRequest request) {
        int pageSize = 10;
        int pagecode = 1;

        if(pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        //在session获取用户id
       /* String uid = (String)request.getSession().getAttribute("roleID");
        PageBean pageBean = invoiceServiceImpl.selectAll(Integer.parseInt(uid), pageCode, pageSize);*/
        PageBean pageBean = invoiceServiceImpl.selectAll(10, pagecode, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/indata/data.jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/insertBatchRecord", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertBatchRecord(@RequestParam("file") MultipartFile file, String uid, HttpServletResponse response) throws Exception{

        //获取数据源
        try {
            System.out.println(uid);
            InputStream inputStream = file.getInputStream();
            invoiceServiceImpl.insertByBatch(Integer.valueOf(uid), inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/text;charset=UTF-8");

        return "上传成功！";
    }

    /**
     * 添加单数据
     * @param invoiceCustom
     * @param request
     */
    @RequestMapping("/insertOneRecord")
    public void insertOneRecord(InvoiceCustom invoiceCustom, HttpServletRequest request) {
        System.out.println(invoiceCustom.getNumber()+"---"+invoiceCustom.getName()+"---"+invoiceCustom.getKind()+"---"+
                invoiceCustom.getMoney()+"---"+invoiceCustom.getDate());
        System.out.println(invoiceCustom.getUid());
        try {
            invoiceServiceImpl.insertOneRecord(invoiceCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载Excel模板
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
