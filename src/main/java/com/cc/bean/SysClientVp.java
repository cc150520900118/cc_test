package com.cc.bean;

import java.util.Date;

public class SysClientVp extends PageBean{
    private String id;

    private String vid;

    private String pid;

    private String scbz;

    private Date lrsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getScbz() {
        return scbz;
    }

    public void setScbz(String scbz) {
        this.scbz = scbz == null ? null : scbz.trim();
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }
}