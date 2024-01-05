package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

    @PostMapping("/cal")
    public String calculator(@RequestParam int number1, @RequestParam int number2, @RequestParam Character operator, Model model) {
        int result;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            default:
                result = number1 / number2;
                break;
        }
        model.addAttribute("result", result);
        return "home";
    }
}
