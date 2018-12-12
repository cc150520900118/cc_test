package com.cc.bean;

public class SysAfisclient extends PageBean{
    private int cid;

    private String username;

    private String password;

    private String clientip;

    private String md5;

    private String clientmac;

    private String optunit;

    private String optuser;

    private String remark;

    private String clientunitname;

    private  String scbz;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip == null ? null : clientip.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getClientmac() {
        return clientmac;
    }

    public void setClientmac(String clientmac) {
        this.clientmac = clientmac == null ? null : clientmac.trim();
    }

    public String getOptunit() {
        return optunit;
    }

    public void setOptunit(String optunit) {
        this.optunit = optunit == null ? null : optunit.trim();
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser == null ? null : optuser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getClientunitname() {
        return clientunitname;
    }

    public void setClientunitname(String clientunitname) {
        this.clientunitname = clientunitname;
    }

    public String getScbz() {
        return scbz;
    }

    public void setScbz(String scbz) {
        this.scbz = scbz;
    }


}