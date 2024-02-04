package com.tutorial.apiapplication.repository;

import com.tutorial.apiapplication.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc just demostrate the concept
 */

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    // for init the data
    static {
        DATABASE.add(new Employee(1, "John", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymond", "alex@gmail.com"));
        DATABASE.add(new Employee(3, "David", "Cameron", "david@gmail.com"));
    }


    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return List.copyOf(DATABASE);
    }

    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public boolean updateEmployee(Employee employee) {
        DATABASE
                .stream()
                .map(emp -> {
                            if (emp.getId().equals(employee.getId())) {
                                return employee;
                            }
                            return emp;
                        }
                );
        return true;
    }

    public boolean deleteById(Integer id) {
        Employee employee = DATABASE
                .stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow();

        DATABASE.remove(employee);
        return true;
    }

}
