package com.example.validate_song_infor.service;

import com.example.validate_song_infor.model.Song;
import com.example.validate_song_infor.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository songRepository;
    @Override
    public List<Song> showList() {
        return songRepository.findAll();
    }
    @Override
    public boolean save(Song song) {
        songRepository.save(song);
        return true;
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).get();
    }
}
