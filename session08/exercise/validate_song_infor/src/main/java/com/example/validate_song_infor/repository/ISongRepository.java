package com.example.validate_song_infor.repository;

import com.example.validate_song_infor.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
}
