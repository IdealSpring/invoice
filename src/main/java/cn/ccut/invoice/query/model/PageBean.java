package cn.ccut.invoice.query.model;

import java.util.List;

/**
 * 分页显示类
 */
public class PageBean {
    //用户ID
    private int uid;
    //页码
    private int pageCode;
    //总记录数
    private int totalRecord;
    //每页记录数
    private int pageSize;
    //当页数据
    private List<QueryCustom> list;

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

    public List<QueryCustom> getList() {
        return list;
    }

    public void setList(List<QueryCustom> list) {
        this.list = list;
    }
}
