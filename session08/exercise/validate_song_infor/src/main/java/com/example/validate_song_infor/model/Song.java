package com.example.validate_song_infor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Song {
    @NotBlank
    @Size(max = 800, message = "Only enter a maximum of 800 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String name;
    @NotBlank
    @Size(max = 300, message = "Only enter a maximum of 300 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String singer;
    @NotBlank
    @Size(max = 1000, message = "Only enter a maximum of 1000 characters !")
    @Pattern(regexp =  "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Not contain special characters !")
    private String type;

    public Song() {
    }

    public Song(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
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
