package com.example.employees.controller;


import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String home() {
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String homePage(Model model) {
        model.addAttribute("employees", service.findAll());
        return "index";
    }

    @GetMapping("/employees/show-form-add-employee")
    public String formAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "form-add-employee";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "update-employee-form";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployeeById(@RequestParam("id") int id) {
        service.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/preview")
    public String previewEmployeePage(@RequestParam("id") int id, Model model) {
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "preview";
    }
}
