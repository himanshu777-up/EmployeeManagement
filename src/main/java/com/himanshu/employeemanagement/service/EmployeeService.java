package com.himanshu.employeemanagement.service;

import com.himanshu.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void addRandomEmployees();
    Employee getEmpById(String id);

}
