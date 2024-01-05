package com.example.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiments, Model model) {
        model.addAttribute("condiment", condiments);
        return "result";
    }
}
