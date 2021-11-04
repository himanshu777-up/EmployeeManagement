package com.himanshu.employeemanagement.controller;

import com.himanshu.employeemanagement.model.Employee;
import com.himanshu.employeemanagement.service.EmployeeService;
import com.himanshu.employeemanagement.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmployeeController {

    //Creating method - handler for home page index.html to display list of employees

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmp", employeeService.getAllEmployee());
        return "index";
    }

    @PostMapping("/addEmp")
    public String addEmpl(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        System.out.println("Employee added");
        return "employee-added";
    }
    
    

}
