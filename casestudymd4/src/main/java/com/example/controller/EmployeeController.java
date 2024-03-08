package com.example.controller;

import com.example.model.employee.Employee;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    IEmployeeService employeeService;

    @RequestMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int pagenumber) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(pagenumber, 5, sort);

        ModelAndView modelAndView = new ModelAndView("/employee/list", "page", employeeService.showList(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("employee/create", "employee", new Employee());
        modelAndView.addObject("position", positionService.showList());
        modelAndView.addObject("division", divisionService.showList());
        modelAndView.addObject("educationDegree", educationDegreeService.showList());
        modelAndView.addObject("title", "Create new Employee");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("Successfully");
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("employee/create", "employee", employeeService.findById(id).get());
        modelAndView.addObject("position", positionService.showList());
        modelAndView.addObject("division", divisionService.showList());
        modelAndView.addObject("educationDegree", educationDegreeService.showList());
        modelAndView.addObject("title", "Update Employee");
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted");
        return "redirect:/employee/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("employee/view", "emplyee", employeeService.findById(id));
    }
}
