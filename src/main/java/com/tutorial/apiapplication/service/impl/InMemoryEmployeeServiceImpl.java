package com.tutorial.apiapplication.service.impl;

import com.tutorial.apiapplication.model.Employee;
import com.tutorial.apiapplication.repository.InMemoryEmployeeRepository;
import com.tutorial.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    // for dependency injection through the "@RequiredArgsConstructor"
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee findById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
