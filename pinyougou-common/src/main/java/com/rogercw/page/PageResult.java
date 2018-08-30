package com.rogercw.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/30 12:45
 * @Version 1.0
 * 分页结果类
 */
public class PageResult implements Serializable {

    private List rows;//每页显示的集合
    private long total;//查询到的总记录数

    public PageResult(List rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public PageResult() {
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
