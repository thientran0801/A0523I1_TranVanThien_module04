package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @RequestMapping("/")
    public ModelAndView showList() {
        List<Blog> list = blogService.showList();
        ModelAndView modelAndView = new ModelAndView("list", "list", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveBlog(@RequestParam("file") MultipartFile file, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        String image = StringUtils.cleanPath(file.getOriginalFilename());
//        if (image.contains("..")) {
//            System.out.println("File note found !");
//        }
        try {
            blog.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Successfully");
        blogService.add(blog);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBlog(@PathVariable long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable long id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update", "blog", blog);
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@RequestParam("file") MultipartFile file, @ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        try {
            blog.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Updated ");
        blogService.update(blog);
        return "redirect:/";
    }
}
