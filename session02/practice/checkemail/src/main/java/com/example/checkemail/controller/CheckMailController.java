package com.example.checkemail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class CheckMailController {
    private static final String REGEX = "^[A_Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
/*    private static Pattern pattern;
    private Matcher matcher;

    public CheckMailController() {
        pattern = Pattern.compile(REGEX);
    }*/
    @GetMapping("/")
    public String showForm() {
        return "form";
    }
    @PostMapping("/check")
    public String checkMail(@RequestParam String email, Model model) {
//        boolean isValid = this.validate(email);
        if (email.matches(REGEX)) {
            model.addAttribute("email", email);
            return "success";
        }
        model.addAttribute("message", "Email is invalid");
        return "form";
    }
/*    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }*/

}