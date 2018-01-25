package cn.ccut.invoice.statistics.model;

import java.util.Set;

/**
 * 数据传输
 */
public class StatisticsQueryVo {
    //所有年份
    private Set<String> years;

    //选中的年份
    private String year;

    //各月份进项数据
    private int[] inputDate;

    //各月份销项数据
    private int[] outputDate;

    public Set<String> getYears() {
        return years;
    }

    public void setYears(Set<String> years) {
        this.years = years;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int[] getInputDate() {
        return inputDate;
    }

    public void setInputDate(int[] inputDate) {
        this.inputDate = inputDate;
    }

    public int[] getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(int[] outputDate) {
        this.outputDate = outputDate;
    }
}
