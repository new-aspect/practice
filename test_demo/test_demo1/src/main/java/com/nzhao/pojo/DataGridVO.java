package com.nzhao.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11507
 */
public class DataGridVO {
    private Integer total;
    private List rows;
    private String errMsg;

    public DataGridVO(){
        rows = new ArrayList(0);
    }

    public DataGridVO(String errMsg) {
        rows = new ArrayList(0);
        this.errMsg = errMsg;
    }

    public DataGridVO(List rows) {
        if (rows != null) {
            this.rows = rows;
            this.total = rows.size();
        }

    }

    public DataGridVO(int total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return this.rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "DataGridVO{" +
                "total=" + total +
                ", rows=" + rows +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}

