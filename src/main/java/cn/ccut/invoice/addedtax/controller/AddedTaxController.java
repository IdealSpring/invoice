package cn.ccut.invoice.addedtax.controller;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
import cn.ccut.invoice.addedtax.model.PageBean;
import cn.ccut.invoice.addedtax.service.AddedTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView taxStatisticsDetail(String date, String pagecode, HttpServletRequest request) throws Exception {
        int pageSize = 10;
        int pageCode = 1;

        if(pagecode != null) {
            pageCode = Integer.parseInt(pagecode);
        }

        // 在session中获取用户id(uid)
        Integer uid = (Integer) request.getSession().getAttribute("roleID");

        PageBean pageBean = addedTaxService.selectByDate(uid, date, pageCode, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/addedtax/taxstatisticsdetail.jsp");
        return modelAndView;
    }
}
