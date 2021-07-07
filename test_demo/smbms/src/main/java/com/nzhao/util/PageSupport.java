package com.nzhao.util;

/**
 * @author 11507
 */
public class PageSupport {
    /**
     * 当前页面，来自前端请求
     */
    public int currentPageNo = 1;

    /**
     * 查询总条数
     */
    public int totalCount;

    /**
     * 页面容量
     */
    public int pageSize = 0;

    /**
     * 总页数，总页数=totalCount% pageSize== 0 ? totalCount/ pageSize : totalCount/ pageSize+ 1 ;
     */
    public int totalPageCount = 1;

    //getter and setter

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo > 0) {
            this.currentPageNo = currentPageNo;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
        }
        if (pageSize > 0 && totalCount > 0) {
            this.setTotalPageCount();
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (pageSize > 1 && totalCount > 1) {
            this.setTotalPageCount();
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    private void setTotalPageCount() {
        this.totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }
}
