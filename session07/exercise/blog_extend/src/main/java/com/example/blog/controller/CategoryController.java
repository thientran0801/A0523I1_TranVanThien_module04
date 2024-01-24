package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/list")
    public ModelAndView showList() {
        List<Category> list = categoryService.showList();
        ModelAndView modelAndView = new ModelAndView("category/list","list", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("category/create", "category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","Saved");
       return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/category/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/update", "category", category);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }
}
