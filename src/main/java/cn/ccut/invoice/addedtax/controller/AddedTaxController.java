package cn.ccut.invoice.addedtax.controller;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.model.PageBean;
import cn.ccut.invoice.addedtax.service.AddedTaxService;
import cn.ccut.invoice.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @authorMr.Robot
 * @create2018-02-05 20:58
 */
@Controller
@RequestMapping("/addedtax")
public class AddedTaxController {

    @Autowired
    private AddedTaxService addedTaxService;

    /**
     * 计算增值税数据
     * @param request
     * @param addedTaxQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping("/taxStatistics")
    public ModelAndView taxStatistics(HttpServletRequest request, AddedTaxQueryVo addedTaxQueryVo) throws Exception {
        List<AddedTaxCustom> addedTaxList = addedTaxService.findInvoiceList(addedTaxQueryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("addedTaxList", addedTaxList);
        modelAndView.setViewName("/jsps/addedtax/taxstatistics.jsp");


        return modelAndView;
    }

    /**
     * 分页显示详细信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/taxStatisticsDetail")
    public ModelAndView taxStatisticsDetail(String pageCode, HttpServletRequest request) throws Exception {
        //@RequestParam(value = "date") String date,
        int pageSize = 10;
        int pagecode = 1;
        if(pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String date = (String)request.getSession().getAttribute("date1");

        // 在session中获取用户id(uid)
        Integer uid = (Integer) request.getSession().getAttribute("roleID");

        PageBean pageBean = addedTaxService.selectByDate(uid, date, pagecode, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/addedtax/taxstatisticsdetail.jsp");

        return modelAndView;
    }

    /**
     * 显示详细信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/taxStatisticsDetailQuery")
    public ModelAndView taxStatisticsDetailQuery(@RequestParam(value="date", required=true, defaultValue="0000") String date, HttpServletRequest request) throws Exception {
        int pageSize = 10;
        int pagecode = 1;

        if(date != "0000"){
            String d1 = date.substring(0, 23);
            String d2 = date.substring(24);
            date = d1.concat("+").concat(d2);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yy", Locale.ENGLISH);
            Date d = dateFormat.parse(date);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
            date = dateFormat2.format(d);
            request.getSession().setAttribute("date1", date);
        } else {
            throw new CustomException("未知错误");
        }

        // 在session中获取用户id(uid)
        Integer uid = (Integer) request.getSession().getAttribute("roleID");

        PageBean pageBean = addedTaxService.selectByDate(uid, date, pagecode, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/addedtax/taxstatisticsdetail.jsp");

        return modelAndView;
    }
}
