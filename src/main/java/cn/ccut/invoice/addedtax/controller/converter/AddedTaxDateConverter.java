package cn.ccut.invoice.addedtax.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发票日期转换
 *  将日期串转换成日期类型(格式yyyy-MM)
 *
 * @authorMr.Robot
 * @create2018-02-06 23:26
 */
public class AddedTaxDateConverter implements Converter<String, Date>{

    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");

        try {
            // 转成直接返回
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 若参数绑定失败返回null
        return null;
    }
}
