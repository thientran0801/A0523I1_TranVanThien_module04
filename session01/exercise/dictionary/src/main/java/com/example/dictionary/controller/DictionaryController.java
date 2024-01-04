package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> list = new LinkedHashMap<>();
    static {
        list.put("blue", "màu xang dương");
        list.put("yellow", "màu vàng");
        list.put("red", "màu đỏ");
        list.put("tree", "cây");
        list.put("hello", "xin chào");
        list.put("drive", "lái xe");
        list.put("cloud", "mây");
        list.put("help", "giúp đỡ");
        list.put("visit", "thăm viếng");
        list.put("parent", "ba mẹ");
        list.put("mother", "mẹ");
        list.put("father", "bố");
    }

    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

    @PostMapping("/translate")
    public String showResult(@RequestParam String english, Model model) {
        String vietnamese = null;
        for (Map.Entry<String, String> entry: list.entrySet()) {
            if (entry.getKey().equals(english.toLowerCase())) {
                vietnamese = entry.getValue();
                break;
            }
        }
        if (vietnamese == null) {
            vietnamese = "keyword not found !";
        }
        model.addAttribute("vietnamese", vietnamese);
        return "home";
    }
}
