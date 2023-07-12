package com.entity;

import java.util.List;

public class PageBean<T> {
    private List<T> list;		//数据列表
    private int currentPage;    //当前页数
    private int pageSize;       //页大小
    private int totalCount;    //总条数
    public PageBean() {
        super();
    }

    public PageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
        super();
        this.list = list;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
