package com.example.controller;

import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int pagenumber) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(pagenumber, 5, sort);
        return new ModelAndView("customer/list", "page", customerService.showList(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("customer/create", "customer", new Customer());
        modelAndView.addObject("customerType", customerTypeService.showList());
        modelAndView.addObject("title", "Create new customer: ");
        return modelAndView;
    }

/*    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes, @RequestParam String gender) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Saved");
        return "redirect:/customer/list";
    }*/

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult, RedirectAttributes redirectAttributes,  Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "/customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Saved");
        return "redirect:/customer/list";
    }
/*
    public String save(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("song", song);
            return "add";
        }else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Updated");
            return "redirect:/";
        }
    }*/

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/create", "customer", customerService.findById(id).get());
        modelAndView.addObject("customerType", customerTypeService.showList());
        modelAndView.addObject("title", "Update customer: ");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("customer/view", "customer", customerService.findById(id).get());
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long iddelete, RedirectAttributes redirectAttributes) {
        customerService.delete(iddelete);
        redirectAttributes.addFlashAttribute("message", "Deleted");
        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public ModelAndView findByKeyword(@RequestParam String keyword, @RequestParam(defaultValue = "0", required = false) int pagenumber) {
        Pageable pageable = PageRequest.of(pagenumber, 5);
        return new ModelAndView("customer/list", "page", customerService.findByKey(keyword, pageable));
    }
}
