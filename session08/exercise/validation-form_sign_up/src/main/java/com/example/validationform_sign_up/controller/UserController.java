package com.example.validationform_sign_up.controller;

import com.example.validationform_sign_up.model.User;
import com.example.validationform_sign_up.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    @GetMapping("/")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("formCreate", "user", new User());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("formCreate", "user", user);
        }
        userService.add(user);
        List<User> list = userService.showList();
        ModelAndView modelAndView = new ModelAndView("list", "list", list);
        return modelAndView;
    }
}