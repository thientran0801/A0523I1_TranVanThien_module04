package com.example.controller;

import com.example.model.facility.Facility;
import com.example.repository.facility.FacilityTypeRepository;
import com.example.repository.facility.RentTypeRepository;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/facility")
@Controller
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @RequestMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int pagenumber) {
        Sort sort = Sort.by("facilityType").ascending();
        Pageable pageable = PageRequest.of(pagenumber, 3, sort);
        Page<Facility> page = facilityService.showList(pageable);

        ModelAndView modelAndView = new ModelAndView("facility/list", "page", page);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("facility/create", "facility", new Facility());
        modelAndView.addObject("rentType", rentTypeService.showList());
        modelAndView.addObject("facilityType", facilityTypeService.showList());
        modelAndView.addObject("title", "Create new facility");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Successfully");
        return "redirect:/facility/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("facility/create", "facility", facilityService.findById(id));
        modelAndView.addObject("rentType", rentTypeService.showList());
        modelAndView.addObject("facilityType", facilityTypeService.showList());
        modelAndView.addObject("title", "Update facility");
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long iddelete, RedirectAttributes redirectAttributes) {
        facilityService.delete(iddelete);
        redirectAttributes.addFlashAttribute("message", "Successfully");
        return "redirect:/facility/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("facility/view", "facility", facilityService.findById(id).get());
    }
}
