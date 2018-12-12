package com.cc.bean;

/**
 *  layui数据表格返回数据处理类
 * Created by yutons on 2017/9/1
 */

public class PageBean {
    //当前页
    private int page;
    //页大小
    private int limit;
    //起始
    private int begin;
    //结束
    private int end;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBegin() {
        return (this.page-1)*this.limit+1;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return  this.page*this.limit;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
