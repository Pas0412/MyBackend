package com.example.mybackend.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collections")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int category;
    private String url;
    private String tags;
    private int thumbs;

    // 构造函数、Getter和Setter方法等
    public Collection() {
    }

    public Collection(String title, int category, String url, String tags) {
        this.title = title;
        this.category = category;
        this.url = url;
        this.tags = tags;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTags() {
        return tags;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }
}

