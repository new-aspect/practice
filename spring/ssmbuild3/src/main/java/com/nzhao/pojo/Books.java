package com.nzhao.pojo;

/**
 * @author 11507
 */
public class Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;

    /**
     * 无参构造
     */
    public Books() {
    }

    //getter and setter

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
