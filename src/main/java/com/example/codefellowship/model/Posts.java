package com.example.codefellowship.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Posts extends EntityModel{

    @ManyToOne
    private Users users;
    private String imageFilePath;
    private String title ;
    private String content;
    private Integer likes;

    public Posts(String title, String content, String imageFilePath) {
        this.imageFilePath = imageFilePath;
        this.title = title;
        this.content = content;
    }

    public Posts() {
    }


    public Posts(Users users, String imageFilePath, String title, String content, Integer likes) {
        this.users = users;
        this.imageFilePath = imageFilePath;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }


    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
