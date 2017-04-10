package com.gogokwon.model;

import java.util.Date;

/**
 * Created by KJShin on 2017-04-09.
 */
public class Post {
    private String href;
    private String title;
    private String subtitle;
    private Date date;

    public Post(String href, String title, String subtitle) {
        this.href = href;
        this.title = title;
        this.subtitle = subtitle;
        this.date = new Date();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
