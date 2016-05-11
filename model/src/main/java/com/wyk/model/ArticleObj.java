package com.wyk.model;

import java.io.Serializable;

/**
 * 文章类型
 * Created by wyk on 2015/12/3.
 */


@SuppressWarnings("serial")
public class ArticleObj implements Serializable {
    private int id;
    private String title;
    private String imgurl;
    private String url;
    private String summary;
    private String createtime;

    @Override
    public String toString() {
        return "ArticleObj{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
