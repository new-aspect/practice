package com.nzhao.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11507
 */
public class DataGridVO {
    private int total = 0;
    private List rows = new ArrayList(0);
    private String errMsg;

    public DataGridVO(String errMsg) {
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
}

