package com.example.validate_song_infor.controller;

import com.example.validate_song_infor.model.Song;
import com.example.validate_song_infor.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @RequestMapping("/")
    public ModelAndView showList() {
        List<Song> list = songService.showList();
        ModelAndView modelAndView = new ModelAndView("list", "list", list);
        return modelAndView;
    }
    @RequestMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("add", "song", new Song());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("song", song);
            return "add";
        }else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Updated");
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("song", song);
            return "update";
        }else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Updated");
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showForm(@PathVariable Long id) {
        Song song = songService.findById(id);
        return new ModelAndView("update", "song", song);
    }
}
