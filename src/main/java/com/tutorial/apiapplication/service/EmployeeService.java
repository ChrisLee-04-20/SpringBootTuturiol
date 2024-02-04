package com.tutorial.apiapplication.service;

import com.tutorial.apiapplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    // Save an employee
    Employee addEmployee(Employee employee);

    // Get employees
    List<Employee> getAllEmployee();

    // Get one employee
    Employee findById(Integer id);

    // Update employee
    boolean updateEmployee(Employee employee);

    // Delete employee
    boolean deleteById(Integer id);

}
