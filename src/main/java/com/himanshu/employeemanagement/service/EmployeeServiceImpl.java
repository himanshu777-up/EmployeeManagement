package com.himanshu.employeemanagement.service;

import com.himanshu.employeemanagement.model.Employee;
import com.himanshu.employeemanagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
    	
        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee(1, "abc1", "abc2", "abc@abc"));
        employeeRepo.save(new Employee(1, "abc1", "abc2", "abc@abc"));
        employeeRepo.findAll().forEach(employeeList::add);
        System.out.println("Method called to get the list of all the employees");
        for(Employee employee: employeeList) {

            System.out.println(employee);
        }
        return employeeList;

//        return (List<Employee>) employeeRepo.findAll();
    }

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }


}
