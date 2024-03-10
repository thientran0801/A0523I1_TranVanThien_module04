package com.example.validate_song_infor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 10, message = "Only enter a maximum of 10 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String name;
    @NotBlank
    @Size(max = 15, message = "Only enter a maximum of 15 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String singer;
    @NotBlank
    @Size(max = 15, message = "Only enter a maximum of 15 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String type;

    public Song() {
    }

    public Song(Long id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
