package cn.ccut.invoice.addedtax.controller;

import cn.ccut.invoice.addedtax.model.AddedTaxCustom;
import cn.ccut.invoice.addedtax.model.AddedTaxQueryVo;
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

    @RequestMapping("/taxStatistics")
    public ModelAndView taxStatistics(HttpServletRequest request, AddedTaxQueryVo addedTaxQueryVo) throws Exception {
        System.out.println("controller1------------------------------");

        List<AddedTaxCustom> addedTaxList = addedTaxService.findInvoiceList(addedTaxQueryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("addedTaxList", addedTaxList);
        System.out.println("controller2------------------------------");
        modelAndView.setViewName("/jsps/addedtax/taxstatistics.jsp");
        System.out.println("controller3------------------------------");

        return modelAndView;
    }
}
