package com.wjs.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 诸夏 QQ:1372339756
 */
public class PageBean<T> implements Serializable {
    private int totalCount;//总记录数
    private int totalPage;//总页数  totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1
    private List<T> list;//该页显示的数据
    private int currentPage;//当前页码
    private int rows;//每页显示的数据条数

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, List<T> list, int currentPage, int rows) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


}
