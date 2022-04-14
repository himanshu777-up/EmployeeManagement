package com.himanshu.employeemanagement.service;

import com.himanshu.employeemanagement.model.Employee;
import com.himanshu.employeemanagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> employeeList = new ArrayList<>();

        employeeRepo.save(new Employee("1", "abc1", "abc2", "abc@abc"));
        employeeRepo.findAll().forEach(employeeList::add);
        System.out.println("Method called to get the list of all the employees");
        for (Employee employee : employeeList) {

            System.out.println(employee);
        }
        return employeeList;

//        return (List<Employee>) employeeRepo.findAll();
    }

    @Override
    public void addRandomEmployees() {
        System.out.println("Inserting random employees from 1 to 10 methomd called");
        for (int idx = 1; idx <= 10; idx++) {
            int i = (int)(Math.random()*(100-1)+1);
            employeeRepo.save(new Employee(i+"", "abc" + i, "abc" + i + "last", "abc" + i + "@abc"));
        }

    }

    @Override
    public Employee getEmpById(String id) {
        System.out.println("find emp by id called     "+id);
        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        Employee emp = null;
        for(Employee employee : employeeList){
            if(employee.getId().equals(id)){
                emp = employee;
                break;
            }
        }
        if(emp.equals(null)){
            throw new RuntimeException("emp not found");
        }
        System.out.println(emp);
        return emp;

    }

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


}
