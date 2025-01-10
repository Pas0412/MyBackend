package com.example.mybackend.DTO;
import java.util.ArrayList;
import java.util.List;

public class CollectionDTO {
    private int id;
    private String title;
    private String url;
    private int thumbs;
    private List<String> tags;
    private String category;

    // 生成Getter和Setter方法
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getThumbs() {
        return thumbs;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategoryName(String category) {
        this.category = category;
    }
}
