package com.example.xia_day03_two;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class User {
    private String desc;
    private String url;

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User(String desc, String url) {

        this.desc = desc;
        this.url = url;
    }
}
