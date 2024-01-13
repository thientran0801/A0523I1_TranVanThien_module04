package com.example.email_management.controller;

import com.example.email_management.model.SettingMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailSettingController {
    @ModelAttribute("listlanguage")
    public String[] showListLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("listsize")
    public int[] showListSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @RequestMapping("/")
    public ModelAndView showFormSetting(Model model) {
        ModelAndView modelAndView = new ModelAndView("formsetting", "settingmail", new SettingMail());
        return modelAndView;
//        model.addAttribute("settingmail", new SettingMail());
//        return "formsetting";
    }

    @PostMapping("/savesetting")
    public String save(@ModelAttribute() SettingMail settingMail, Model model) {
        model.addAttribute("language", settingMail.getLanguage());
        model.addAttribute("size", settingMail.getPageSize());
        model.addAttribute("spamsfilter", settingMail.isSpamsFilter());
        model.addAttribute("signature", settingMail.getSignature());
        return "display";
    }
}
