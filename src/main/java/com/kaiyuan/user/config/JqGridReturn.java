package com.kaiyuan.user.config;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class JqGridReturn {
    /**
     * 总共条数
     */
    private int total = 0;

    /**
     * 当前页数
     */
    private int p = 1;

    /**
     * 内容数据
     */
    private List<?> rows = new ArrayList();

    /**
     * 脚表头数?
     */
    private List<?> footer = new ArrayList();

    private int totolPage;

    private int pageSize=10;

    public JqGridReturn() {
    }

    public JqGridReturn(int total, int p, List<?> rows, List<?> footer, int totolPage, int pageSize) {
        this.total = total;
        this.p = p;
        this.rows = rows;
        this.footer = footer;
        this.totolPage = totolPage;
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public List<?> getFooter() {
        return footer;
    }

    public void setFooter(List<?> footer) {
        this.footer = footer;
    }

    public int getTotolPage() {
        return totolPage;
    }

    public void setTotolPage(int totolPage) {
        this.totolPage = totolPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "JqGridReturn{" +
                "total=" + total +
                ", p=" + p +
                ", rows=" + rows +
                ", footer=" + footer +
                ", totolPage=" + totolPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
