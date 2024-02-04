package com.tutorial.apiapplication.resource;

import com.tutorial.apiapplication.model.Employee;
import com.tutorial.apiapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
//@RequiredArgsConstructor
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees () {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
        employee.setId(employeeService.getAllEmployee().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateEmployees (@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable("id") Integer id)  {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    private URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").buildAndExpand(id).toUri();
    }

}
