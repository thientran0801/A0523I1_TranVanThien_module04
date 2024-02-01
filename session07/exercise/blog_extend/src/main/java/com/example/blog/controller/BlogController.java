package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page) {
        Sort sort = Sort.by("dateCreate").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Blog> blogPage = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("blog/list", "blogPage", blogPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("blog/create", "blog", new Blog());
        modelAndView.addObject("listCategory", categoryService.showList());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateCreate(new Date());
        if (blog.getId() != null) {
            Blog oldBlog = blogService.findById(blog.getId());
            blog.setDateCreate(oldBlog.getDateCreate());
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully");
        return "redirect:/blog/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable long id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete");
        return "redirect:/blog/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/update", "blog", blog);
        modelAndView.addObject("listCategory", categoryService.showList());
        return modelAndView;
    }

    @PostMapping("/findbykey")
    public ModelAndView findByKey(@RequestParam(defaultValue = "0", required = false) int page,
                                  @RequestParam String keyword) {
        Sort sort = Sort.by("title");
        Pageable pageable = PageRequest.of(page,Integer.MAX_VALUE);
        Page<Blog> blogPage = blogService.findByKey(keyword, pageable);
        ModelAndView modelAndView = new ModelAndView("blog/list", "blogPage", blogPage);
        return modelAndView;
    }
}
