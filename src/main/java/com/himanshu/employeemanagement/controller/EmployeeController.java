package com.himanshu.employeemanagement.controller;

import com.himanshu.employeemanagement.model.Employee;
import com.himanshu.employeemanagement.service.EmployeeService;
import com.himanshu.employeemanagement.service.EmployeeServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    //Creating method - handler for home page index.html to display list of employees

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmp", employeeService.getAllEmployee());
        return "index";
    }

    //method handler for showNew Emp Form
    @GetMapping("/showNewEmpForm")
    public String showNewEmpForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_emp_added";
    }

    @PostMapping("/saveEmployee")
    public String addEmpl(@ModelAttribute("emplopyee") Employee employee) {
        employeeService.addEmployee(employee);
        System.out.println("Employee added");
        return "redirect:/";
    }


    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") String id, Model model) {
        Employee employee = employeeService.getEmpById(id);
        System.out.println("Controller message");
        System.out.println(employee);
        model.addAttribute("employee", employee);
        System.out.println(model);
        return "update_emp";
    }




    @RequestMapping(method = RequestMethod.POST, value = "/addRandEmp")
    public String addRandomEmp() {
        System.out.println("controller method random called3");
        employeeService.addRandomEmployees();
        System.out.println("random emp added");
        return "redirect:/";
    }


}
