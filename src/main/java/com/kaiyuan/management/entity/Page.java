package com.kaiyuan.management.entity;

public class Page {

    private int currentpage=1;//当前页
    private int totalpage;//总页数
    private int totalrows;//总条数
    private int pagesize=10;//每页大小
    private int startrow=0;//开始页
    private int starttotal=10;//每页开始条数
    private int Jumppage;//跳转到的页

    public Page() {
    }

    public Page(int currentpage, int totalpage, int totalrows, int pagesize, int startrow, int starttotal, int jumppage) {
        this.currentpage = currentpage;
        this.totalpage = totalpage;
        this.totalrows = totalrows;
        this.pagesize = pagesize;
        this.startrow = startrow;
        this.starttotal = starttotal;
        Jumppage = jumppage;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalrows() {
        return totalrows;
    }

    public void setTotalrows(int totalrows) {
        this.totalrows = totalrows;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getStartrow() {
        return startrow;
    }

    public void setStartrow(int startrow) {
        this.startrow = startrow;
    }

    public int getStarttotal() {
        return starttotal;
    }

    public void setStarttotal(int starttotal) {
        this.starttotal = starttotal;
    }

    public int getJumppage() {
        return Jumppage;
    }

    public void setJumppage(int jumppage) {
        Jumppage = jumppage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentpage=" + currentpage +
                ", totalpage=" + totalpage +
                ", totalrows=" + totalrows +
                ", pagesize=" + pagesize +
                ", startrow=" + startrow +
                ", starttotal=" + starttotal +
                ", Jumppage=" + Jumppage +
                '}';
    }
}
