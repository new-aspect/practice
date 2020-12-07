package com.nzhao.pojo;

import java.util.Date;

/**
 * @author nzhao
 */
public class User {
    private Date birthday;

    public User() {
    }

    public User(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday=" + birthday +
                '}';
    }
}
