package com.example.blog.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateCreate;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String author;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String image;

    public Blog() {
    }

    public Blog(Long id, Date dateCreate, String title, String content, String author, String image) {
        this.dateCreate = dateCreate;
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}