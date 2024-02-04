package com.tutorial.apiapplication.service.impl;

import com.tutorial.apiapplication.model.Employee;
import com.tutorial.apiapplication.repository.JpaEmployeeRepository;
import com.tutorial.apiapplication.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JpaEmployeeServiceImpl implements EmployeeService {
    private JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee) != null;
    }

    @Override
    public boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return true;
    }
}
