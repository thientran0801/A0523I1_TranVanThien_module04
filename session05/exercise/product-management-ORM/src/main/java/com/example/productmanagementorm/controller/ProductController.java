package com.example.productmanagementorm.controller;

import com.example.productmanagementorm.model.Product;
import com.example.productmanagementorm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService service;

    @RequestMapping("/")
    public String showList(Model model) {
        List<Product> list = service.findAll();
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("/add")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create", "product", new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        service.add(product);
        redirectAttributes.addFlashAttribute("message", "successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        service.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update", "product", service.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        service.update(product);
        redirectAttributes.addFlashAttribute("message", "successfully");
        return "redirect:/";
    }

    @PostMapping("/findByName")
    public ModelAndView findByName(@RequestParam String keyword) {
        List<Product> list = service.findByName(keyword);
        ModelAndView modelAndView = new ModelAndView("home", "list", list);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "view";
    }
}
