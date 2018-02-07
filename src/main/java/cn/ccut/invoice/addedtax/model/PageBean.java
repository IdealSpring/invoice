package cn.ccut.invoice.addedtax.model;

import java.util.List;

/**
 * 分页显示
 *
 * @authorMr.Robot
 * @create2018-02-07 19:09
 */
public class PageBean{
    //用户ID
    private int uid;
    //页码
    private int pageCode;
    //总记录数
    private int totalRecord;
    //每页记录数
    private int pageSize;
    //当页数据
    private List<AddedTaxCustom> list;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    /**
     * 计算总页数
     * @return
     */
    public int getTotalPage() {
        int totalPage = totalRecord/pageSize;
        return totalRecord%pageSize == 0?totalPage:totalPage+1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<AddedTaxCustom> getList() {
        return list;
    }

    public void setList(List<AddedTaxCustom> list) {
        this.list = list;
    }
}
