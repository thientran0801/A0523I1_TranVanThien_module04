package com.example.validate_song_infor.controller;

import com.example.validate_song_infor.model.Song;
import com.example.validate_song_infor.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @RequestMapping("/")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("add", "song", new Song());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add", "song", song);
        }
        ModelAndView modelAndView = new ModelAndView("list", "song", new Song());
        return modelAndView;
    }
}
