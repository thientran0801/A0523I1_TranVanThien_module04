package com.example.springusermodel.controller;

import com.example.springusermodel.dao.UserDao;
import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserDao.checkLogin(login);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return  modelAndView;
        }
    }
}