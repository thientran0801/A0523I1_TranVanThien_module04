package com.example.validate_song_infor.service;

import com.example.validate_song_infor.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showList();
    boolean save(Song song);

    Song findById(Long id);

}
