package cn.ccut.invoice.loginlog.model;

import java.util.Date;

public class Log {
    private Integer lid;

    private String username;

    private Integer uid;

    private String ip;

    private Date createdate;

    private Date deletedate;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDeletedate() {
        return deletedate;
    }

    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }
}